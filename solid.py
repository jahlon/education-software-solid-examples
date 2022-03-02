from abc import ABC, abstractmethod


class Order:

    def __init__(self):
        self.items = []
        self.quantities = []
        self.prices = []
        self.status = "open"

    def add_item(self, name, quantity, price):
        self.items.append(name)
        self.quantities.append(quantity)
        self.prices.append(price)

    def total_price(self):
        total = 0
        for i in range(len(self.prices)):
            total += self.quantities[i] * self.prices[i]
        return total


class Authorizer(ABC):

    @abstractmethod
    def is_authorized(self) -> bool:
        pass


class SMSAuthorizer(Authorizer):
    def __init__(self):
        self.authorized = False

    def verify_code(self, code):
        print(f"Verifying SMS code {code}")
        self.authorized = True

    def is_authorized(self) -> bool:
        return self.authorized


class RobotAuthorizer(Authorizer):
    def __init__(self):
        self.authorized = False

    def not_a_robot(self):
        print(f"Verifying not a robot")
        self.authorized = True

    def is_authorized(self) -> bool:
        self.authorized


class PaymentProcessor(ABC):
    @abstractmethod
    def pay(self, order):
        pass


class PaymentProcessorSMS(PaymentProcessor, ABC):

    @abstractmethod
    def auth_sms(self, code):
        pass


class VerifiedPaymentProcessor(PaymentProcessorSMS, ABC):
    def __init__(self, authorizer: Authorizer):
        self.authorizer = authorizer


class DebitPaymentProcessor(VerifiedPaymentProcessor):

    def __init__(self, security_code, authorizer: Authorizer):
        super().__init__(authorizer)
        self.security_code = security_code

    def pay(self, order):
        if not self.authorizer.is_authorized():
            raise Exception("Not authorized")
        print("Processing debit payment type")
        print(f"Verifying security code: {self.security_code}")
        order.status = "paid"


class CreditPaymentProcessor(PaymentProcessor):

    def __init__(self, security_code):
        self.security_code = security_code

    def pay(self, order):
        print("Processing credit payment type")
        print(f"Verifying security code: {self.security_code}")
        order.status = "paid"


class PaypalPaymentProcessor(VerifiedPaymentProcessor):
    def __init__(self, email, authorizer: Authorizer):
        super().__init__(authorizer)
        self.email = email

    def pay(self, order):
        if not self.authorizer.is_authorized():
            raise Exception("Not authorized")
        print("Processing paypal payment type")
        print(f"Using email address: {self.email}")
        order.status = "paid"


order = Order()
order.add_item("Keyboard", 1, 50)
order.add_item("SSD", 1, 150)
order.add_item("USB cable", 2, 5)

print(order.total_price())
authorizer = RobotAuthorizer()
processor = PaypalPaymentProcessor("correo@gmail.com", authorizer)
authorizer.verify_code(454545)
processor.pay(order)
