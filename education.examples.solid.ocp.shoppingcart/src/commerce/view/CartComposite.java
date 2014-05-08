package commerce.view;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import swing2swt.layout.BorderLayout;

import commerce.model.Cart;
import commerce.model.refactored.Item;

public class CartComposite extends Composite {
	private Table tableCart;
	private TableViewer tableViewer;
	private Text textTotal;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CartComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new BorderLayout(0, 0));
		
		tableViewer = new TableViewer(this, SWT.BORDER | SWT.FULL_SELECTION);
		tableCart = tableViewer.getTable();
		tableCart.setLinesVisible(true);
		tableCart.setHeaderVisible(true);
		
		createColumns();
		
		tableViewer.setContentProvider(new ArrayContentProvider());
		
		tableCart.setLayoutData(BorderLayout.CENTER);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(BorderLayout.SOUTH);
		composite.setLayout(new GridLayout(2, false));
		
		Label lblTotal = new Label(composite, SWT.NONE);
		lblTotal.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblTotal.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTotal.setText("Total:");
		
		textTotal = new Text(composite, SWT.BORDER);
		textTotal.setEditable(false);
		textTotal.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	}
	
	private void createColumns() {
		String[] titles = {"#", "Product", "Description", "Price", "Quantity", "Total"};
		int[] bounds = {20, 100, 150, 50, 50, 50};
		
		// First column: #
		TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0]);
		col.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				Item item = (Item)element;
				return Integer.toString(item.getNumber());
			}
		});
		
		// Second column: Product
		col = createTableViewerColumn(titles[1], bounds[1]);
		col.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				Item item = (Item)element;
				return item.getProduct().getName();
			}
		});
		
		// Third column: Description
		col = createTableViewerColumn(titles[2], bounds[2]);
		col.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				Item item = (Item)element;
				return item.getProduct().getDescription();
			}
		});
		
		// Fourth column: Price
		col = createTableViewerColumn(titles[3], bounds[3]);
		col.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				Item item = (Item)element;
				return Double.toString(item.getProduct().getPrice());
			}
		});
		
		// Fifth column: Quantity
		col = createTableViewerColumn(titles[4], bounds[4]);
		col.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				Item item = (Item)element;
				return Integer.toString(item.getQuantity());
			}
		});
		
		// Sixth column: Total
		col = createTableViewerColumn(titles[5], bounds[5]);
		col.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				Item item = (Item)element;
				return Double.toString(item.calculateTotal());
			}
		});
	}
	
	private TableViewerColumn createTableViewerColumn(String title, int bound) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(false);
		return viewerColumn;
	}
	
	public void refreshCart(Cart cart) {
		tableViewer.setInput(cart.getItems());
		tableViewer.refresh();
		textTotal.setText(Double.toString(cart.calculateTotal()));
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
