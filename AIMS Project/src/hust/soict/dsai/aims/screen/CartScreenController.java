package hust.soict.dsai.aims.screen;


import hust.soict.dsai.aims.Aims.Aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;

        
    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;
    
    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;
    
    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    private Label totalCost;
	
	@FXML
	private Button btnPlay;

	@FXML
	private Button btnRemove;
	 
	@FXML 
	private Button placeOrder;

    @FXML
    private MenuItem openStore;

    @FXML
    private MenuItem openCart;

    @FXML
    private MenuItem addBookBtn;

    @FXML
    private MenuItem addCDBtn;

    @FXML
    private MenuItem addDVDBtn;


    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        totalCost.setText(cart.totalCost() + "$");
        
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if(newValue != null) {
                    updateButtonBar(newValue);
                }
            }
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				showFilteredMedia(newValue);
			}
		});
        
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		totalCost.setText(cart.totalCost()+ " $");
	}
    
    void showFilteredMedia(String keyword) {
		ObservableList<Media> res = cart.getItemsOrdered();
		RadioButton curBtn = (RadioButton) filterCategory.getSelectedToggle();
		if(keyword.isEmpty()) {
			tblMedia.setItems(res);
		}else if(curBtn.getText().equals("By ID")) {
			res = FXCollections.observableList(cart.searchById(keyword));
		} else {
			res = FXCollections.observableList(cart.searchByTitle(keyword));
		}
		tblMedia.setItems(res);
	}

    @FXML
    void viewStorePressed(ActionEvent event) {
		new StoreScreen(Aims.store);
    }

    @FXML
    void viewCartPressed(ActionEvent event) {
		new CartScreen(Aims.cart);
    }

    @FXML
	void playBtnPressed() {
		 Media media = tblMedia.getSelectionModel().getSelectedItem();
		 Alert alert;
		 Disc disc = (Disc) media;
		 if(disc.getLength() == 0) {
			alert = new Alert(AlertType.ERROR);
			alert.setContentText("Cannot play this disc");
			alert.show();
		 } else {
			String info = "Title: " + disc.getTitle()
				+ "\nCategory: " + disc.getCategory()
				+ "\nDirector: " + disc.getDirector()
				+ "\nLength: " + disc.getLength()
				+ "\nCost: " + disc.getCost() ;
			alert = new Alert(AlertType.INFORMATION);
			alert.setContentText(info);
			alert.show();
		 }
	}

    @FXML
	void placeOrderPressed(ActionEvent event) {
		emptyCart();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Place order");
		alert.setContentText("Order created");
	    alert.show();
	}
	
	void emptyCart() {
		cart.emptyCart();
		tblMedia.setItems(cart.getItemsOrdered());
		totalCost.setText("0 $");
	}
    
    @FXML
    void addBook(ActionEvent e) {
        new AddBookToStoreScreen();
    }

    @FXML
    void addCD(ActionEvent e) {
        new AddCompactDiscToStoreScreen();
    }

    @FXML
    void addDVD(ActionEvent e) {
        new AddDigitalVideoDiscToStoreScreen();
    }
}
