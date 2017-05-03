package passwordManger;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ToolBar extends HBox{
	//private HBox toolBarBox = new HBox(0);
	private VBox newFileVBox = new VBox();
	private VBox editVBox = new VBox();
	private VBox deleteVBox = new VBox();
	private VBox favBtVBox = new VBox();
	private VBox serchBtVBox = new VBox();
			
	private StackPane newFiStaPane = new StackPane();
	private StackPane editBtStackPane = new StackPane();
	private StackPane deleBtStackPane = new StackPane();
	private StackPane favBtStackPane = new StackPane();
	private StackPane searchStackPane = new StackPane();
			
	private ImageView newFileImg = new ImageView("images/new.png");
	private ImageView editBtImge = new ImageView("images/edit.png");
	private ImageView btDelImagenew = new ImageView("images/delete.png");
	private ImageView favImg = new ImageView("images/fav.png");
	private ImageView searchImg = new ImageView("images/search.png");
			
	private Button btNew = new Button("New");
	private Button btEdit = new Button("Edit");
	private Button btDelete = new Button("Delete");
	private Button btFav = new Button("Fav");
	private Button btSearch = new Button("Search");
	
	public ToolBar(){
		//New File button
		btNew.setId("toolbarBtn");
		newFileVBox.setAlignment(Pos.CENTER);
		newFileVBox.getChildren().addAll(newFileImg, btNew);
		newFiStaPane.getChildren().add(newFileVBox);
		newFiStaPane.setPadding(new Insets(0,12,5,12));
		newFiStaPane.setId("newFileStackPane");
		newFileVBox.setPadding(new Insets(3, -5, -5, -5));
	
		//Edit File button
		btEdit.setId("toolbarBtn");
		editVBox.setAlignment(Pos.CENTER);
		editVBox.getChildren().addAll(editBtImge, btEdit);
		editBtStackPane.getChildren().add(editVBox);
		editBtStackPane.setPadding(new Insets(0,12,5,12));
		editBtStackPane.setId("editBtStackPane");
		editVBox.setPadding(new Insets(3, -5, -5, -5));
	
		//Delete button
		btDelete.setId("toolbarBtn");
		deleteVBox.setAlignment(Pos.CENTER);
		deleteVBox.getChildren().addAll(btDelImagenew, btDelete);
		deleBtStackPane.getChildren().add(deleteVBox);
		deleBtStackPane.setPadding(new Insets(0,5,5,5));
		deleBtStackPane.setId("deleBtStackPane");
		deleteVBox.setPadding(new Insets(8, -5, 0, -5));
	
		//Favorite button
		btFav.setId("toolbarBtn");
		favBtVBox.setAlignment(Pos.CENTER);
		favBtVBox.getChildren().addAll(favImg, btFav);
		favBtStackPane.getChildren().add(favBtVBox);
		favBtStackPane.setPadding(new Insets(0,12,5,12));
		favBtStackPane.setId("favBtStackPane");
		favBtVBox.setPadding(new Insets(3, -5, -5, -5));
	
		//Search button
		btSearch.setId("toolbarBtn");
		serchBtVBox.setAlignment(Pos.CENTER);
		serchBtVBox.getChildren().addAll(searchImg, btSearch);
		searchStackPane.getChildren().add(serchBtVBox);
		searchStackPane.setPadding(new Insets(0,5,5,5));
		searchStackPane.setId("searchStackPane");
		serchBtVBox.setPadding(new Insets(3, -5, -5, -5));
		getStylesheets().addAll(this.getClass().getResource("styles.css").toExternalForm());
		getChildren().addAll(newFiStaPane, editBtStackPane, deleBtStackPane, favBtStackPane, searchStackPane);
	}

	public Button getBtNew() {
		return btNew;
	}


	public Button getBtEdit() {
		return btEdit;
	}

	

	public Button getBtDelete() {
		return btDelete;
	}

	

	public Button getBtFav() {
		return btFav;
	}

	

	public Button getBtSearch() {
		return btSearch;
	}

		

}

