package worker.model;

public class RobotWorker implements IWorker {

	@Override
	public void eat() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void work() {
		System.out.println("RobotWorker is working");

	}

	@Override
	public void sleep() {
		throw new UnsupportedOperationException();
	}

}
