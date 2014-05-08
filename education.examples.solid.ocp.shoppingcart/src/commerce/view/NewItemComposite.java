package commerce.view;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import swing2swt.layout.BorderLayout;

import commerce.model.Product;

public class NewItemComposite extends Composite {
	private Text textQuantity;
	private ComboViewer comboViewer;
	private CommerceWindow controller;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public NewItemComposite(CommerceWindow window, Composite parent, int style) {
		super(parent, style);
		this.controller = window;
		setLayout(new BorderLayout(0, 0));
		
		Group grpNewItem = new Group(this, SWT.NONE);
		grpNewItem.setText("New Item");
		grpNewItem.setLayoutData(BorderLayout.CENTER);
		grpNewItem.setLayout(new FormLayout());
		
		Label lblProduct = new Label(grpNewItem, SWT.NONE);
		FormData fd_lblProduct = new FormData();
		fd_lblProduct.top = new FormAttachment(0, 10);
		fd_lblProduct.left = new FormAttachment(0, 10);
		lblProduct.setLayoutData(fd_lblProduct);
		lblProduct.setText("Product:");
		
		comboViewer = new ComboViewer(grpNewItem, SWT.READ_ONLY);
		Combo comboProduct = comboViewer.getCombo();
		
		comboViewer.setContentProvider(ArrayContentProvider.getInstance());
		comboViewer.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(Object element) {
				if( element instanceof Product ) {
					Product product = (Product)element;
					return product.getName();
				}
				return super.getText(element);
			}
			
		});
		
		FormData fd_comboProduct = new FormData();
		fd_comboProduct.top = new FormAttachment(lblProduct, -3, SWT.TOP);
		fd_comboProduct.left = new FormAttachment(lblProduct, 6);
		fd_comboProduct.right = new FormAttachment(0, 253);
		comboProduct.setLayoutData(fd_comboProduct);
		
		Label lblQuantity = new Label(grpNewItem, SWT.NONE);
		FormData fd_lblQuantity = new FormData();
		fd_lblQuantity.right = new FormAttachment(lblProduct, 0, SWT.RIGHT);
		lblQuantity.setLayoutData(fd_lblQuantity);
		lblQuantity.setText("Quantity:");
		
		textQuantity = new Text(grpNewItem, SWT.BORDER);
		fd_lblQuantity.top = new FormAttachment(textQuantity, 3, SWT.TOP);
		FormData fd_textQuantity = new FormData();
		fd_textQuantity.top = new FormAttachment(comboProduct, 6);
		fd_textQuantity.left = new FormAttachment(comboProduct, 0, SWT.LEFT);
		textQuantity.setLayoutData(fd_textQuantity);
		
		Button btnAddToCart = new Button(grpNewItem, SWT.NONE);
		FormData fd_btnAddToCart = new FormData();
		fd_btnAddToCart.top = new FormAttachment(textQuantity, 15);
		fd_btnAddToCart.left = new FormAttachment(lblQuantity, 0, SWT.LEFT);
		btnAddToCart.setLayoutData(fd_btnAddToCart);
		btnAddToCart.setText("Add to Cart");
		btnAddToCart.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				controller.addItemToCart();
			}
		});
	}
	
	public Product getProduct() {
		IStructuredSelection selection = (IStructuredSelection)comboViewer.getSelection();
		return (Product)selection.getFirstElement();
	}
	
	public int getQuantity() throws QuantityFormatException {
		String text = textQuantity.getText();
		try{
			int q = Integer.parseInt(text);
			return q;
		} catch(NumberFormatException e) {
			throw new QuantityFormatException("The value " + text + " is not a valid integer.");
		}
	}
	
	public void loadProduct(Product[] products) {
		comboViewer.setInput(products);
		comboViewer.refresh();
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
