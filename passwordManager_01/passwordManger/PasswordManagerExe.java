package passwordManger;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class PasswordManagerExe extends Application{
	private VBox appBaseVBox = new VBox();//The base VBox
	private BorderPane beginPagePane = new BorderPane();// For begin Page
	private StackPane stackVBoxPane = new StackPane();//Stack pane for Side VBoxPane
	private StackPane functionPane = new StackPane(); // for each function pages
	
	//Declared global so that can be used wherever it is needed
	private String[] categoryNames = {"Select", "Personal", "Professional", "Financial",
			"Academic", "Social", "Entertainment", "Other"};
	private ComboBox<String> cboCategory = new ComboBox<>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(5.5);
		pane.setVgap(5.5);
		pane.setId("root");
		
		Label userNamelabel = new Label("Username: ");
		userNamelabel.setId("usrPwlabel");
		Label passwordLabel = new Label("Password: ");
		passwordLabel.setId("usrPwlabel");
		
		pane.add(userNamelabel, 0, 0);
		pane.add(new TextField(), 1, 0);
		pane.add(passwordLabel, 0, 1);
		pane.add(new TextField(), 1, 1);
		Button btLogin = new Button("Login");
		btLogin.setId("btLogin");
		
		Button btCancel = new Button("Cancel");
		btCancel.setId("btLogCancel");
		HBox hBox = new HBox(15);
		hBox.getChildren().addAll(btLogin, btCancel);
		hBox.setPadding(new Insets(10,10, 10, 10));
		pane.add(hBox, 1, 3);
		
		Scene scene = new Scene(pane, 400, 400);
		scene.getStylesheets().addAll(this.getClass().getResource("styles.css").toExternalForm());
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setTitle("Password Manager 1.0");
		primaryStage.setScene(scene);
		primaryStage.show();
		

		btLogin.setOnAction(e-> {
			primaryStage.close();
			beginApplication();
		});
		
		btCancel.setOnAction( e -> {
			primaryStage.close();
		});
		
	}
	
	public void beginApplication(){
		/**MenuBar*/
		MenuBar menuBar = new MenuBar();
		menuBar.setId("menuBar");
		Menu menuFile = new Menu("File");
		Menu menuEdit = new Menu("Edit");
		Menu menuView = new Menu("View");
		menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
		
		/**Create new tool bar object*/
		ToolBar toolBar = new ToolBar();
		toolBar.setId("toolBar");
		
		/**Side Box*/
		VBox sideVBox = new VBox(); 
		sideVBox.setId("sideVBox");
		sideVBox.setMinWidth(180);
		sideVBox.setMinHeight(400);
		//Label lblTest = new Label("Test");//test
		sideVBox.setPadding(new Insets(10,50,10,50));
		//sideVBox.getChildren().add(lblTest);
		
		stackVBoxPane.setId("stackVBoxPane");
		stackVBoxPane.setPadding(new Insets(40, 10, 100, 10));
		stackVBoxPane.getChildren().add(sideVBox);
		
		toolBar.getBtNew().setOnAction( e -> {
			createNew();
			//functionPane.getChildren().add(createNew());
		});
		
		toolBar.getBtEdit().setOnAction( e -> {
			editFile();
		});

		toolBar.getBtDelete().setOnAction( e-> {
			
		});
		
		toolBar.getBtFav().setOnAction( e-> {
			
		});
		
		toolBar.getBtSearch().setOnAction( e -> {
			searchFile();
		});
		
		
		/**Border Pane to place all elements*/
		//BorderPane beginPagePane = new BorderPane();// --global
		functionPane.setPadding(new Insets(30, 50, 100, 100));
		beginPagePane.setTop(toolBar);
		beginPagePane.setLeft(stackVBoxPane);
		beginPagePane.setId("basePane");
		appBaseVBox.getChildren().addAll(menuBar, beginPagePane);
		
		
		
		Scene processScene = new Scene(appBaseVBox, 800, 610);
		processScene.getStylesheets().addAll(this.getClass().getResource("styles.css").toExternalForm());
		Stage stage2 = new Stage();
		stage2.setTitle("Password Manager 1.0");
		stage2.setScene(processScene);
		stage2.setResizable(false);
		stage2.show();

	}
	
	public void createNew(){
		
		closePage();
		
		VBox newFileVBox = new VBox();
		newFileVBox.setMinHeight(400);
		newFileVBox.setMinWidth(180);
		newFileVBox.setId("sideVBox");
		GridPane newFilePane = new GridPane();
		newFilePane.setMaxHeight(370);
		newFilePane.setMinWidth(400);
		newFilePane.setPadding(new Insets(20, 10, 20, 10));
		
		Label lblCategory = new Label("Category :");
		lblCategory.setId("newFileLbl");

		
		ObservableList<String> items =
				FXCollections.observableArrayList(categoryNames);
		cboCategory.setValue("Select");
		cboCategory.getItems().addAll(items);
		cboCategory.setId("cboCategory");
		
		//Labels, TextFields, Buttons and ComboBox
		Label lblDescr = new Label("Description :");
		lblDescr.setId("newFileLbl");
		TextField tfDescr = new TextField();
		tfDescr.setId("tfNewFile");
		Label lblUsername = new Label("Username :");
		lblUsername.setId("newFileLbl");
		TextField tfUserName = new TextField();
		tfUserName.setId("tfNewFile");
		Label lblPassword = new Label("Password :");
		lblPassword.setId("newFileLbl");
		TextField tfPassword = new TextField();
		tfPassword.setId("tfNewFile");
		Label lblDetails = new Label("Details :");
		lblDetails.setId("newFileLbl");
		TextArea taDetails = new TextArea();
		taDetails.setId("tfNewFile");
		ScrollPane scrollPane = new ScrollPane(taDetails);
		taDetails.setPrefColumnCount(40);
		taDetails.setPrefRowCount(6);
		scrollPane.setMaxWidth(200);
		Button btSave = new Button("Save");
		btSave.setId("btSave");
		Button btCancel = new Button("Cancel");
		btCancel.setId("btCancel");
		
		//HBox for buttons
		HBox btnHBox = new HBox(15);
		btnHBox.setPadding(new Insets(10,10, 10, 10));
		btnHBox.getChildren().addAll(btSave, btCancel);
		
		newFilePane.setAlignment(Pos.CENTER);
		newFilePane.setHgap(20);
		newFilePane.setVgap(20);
		newFilePane.setId("newFileGridPane");
		newFilePane.add(lblDescr, 0, 0);
		newFilePane.add(tfDescr, 1, 0);
		newFilePane.add(lblUsername, 0, 1);
		newFilePane.add(tfUserName, 1, 1);
		newFilePane.add(lblPassword, 0, 2);
		newFilePane.add(tfPassword, 1, 2);
		newFilePane.add(lblCategory, 0, 3);
		newFilePane.add(cboCategory, 1, 3);
		
		newFilePane.add(lblDetails, 0, 4);
		newFilePane.add(scrollPane, 1, 4);
		newFilePane.add(btnHBox, 1, 5);
		
		//Add the new file page to the base StackPane
		stackVBoxPane.getChildren().add(newFileVBox);
		functionPane.getChildren().add(newFilePane);
		beginPagePane.setCenter(functionPane);
		
		//Process the user inputs
		PasswordManager user = new PasswordManager();
		btSave.setOnAction( e-> {
			//Variables to hold data from user
			String title = tfDescr.getText();
			String username = tfUserName.getText();
			String password = tfPassword.getText();
			String details = taDetails.getText();
			PasswordManager pm = new PasswordManager();
			
			if(cboCategory.getValue() == "Select"){
				Alert alert = new Alert(AlertType.ERROR);
				//alert.initStyle(StageStyle.UNDECORATED);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("You must select a category!");
				alert.showAndWait();
			}else if(cboCategory.getValue() == "Academic"){
				PasswordAccount account = new Personal(title, username, 
						password, details, cboCategory.getValue());
				user.addAccount(account);
				try {
					pm.saveAccount(account);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}else if(cboCategory.getValue() == "Entertainment"){
				PasswordAccount account = new Entertainment(title, username, 
						password, details, cboCategory.getValue());
				user.addAccount(account);
				try {
					pm.saveAccount(account);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}else if(cboCategory.getValue() == "Financial"){
				PasswordAccount account = new Financial(title, username, 
						password, details, cboCategory.getValue());
				user.addAccount(account);
				try {
					pm.saveAccount(account);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}else if(cboCategory.getValue() == "Professional"){
				PasswordAccount account = new Professional(title, username, 
						password, details, cboCategory.getValue());
				user.addAccount(account);
				try {
					pm.saveAccount(account);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}else if(cboCategory.getValue() == "Personal"){
				PasswordAccount account = new Personal(title, username, 
						password, details, cboCategory.getValue());
				user.addAccount(account);
				try {
					pm.saveAccount(account);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}else if(cboCategory.getValue() == "Other"){
				PasswordAccount account = new Other(title, username, 
						password, details, cboCategory.getValue());
				user.addAccount(account);
				try {
					pm.saveAccount(account);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}else if(cboCategory.getValue() == "Social"){
				PasswordAccount account = new Social(title, username, 
						password, details, cboCategory.getValue());
				user.addAccount(account);
				try {
					pm.saveAccount(account);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}//end if
		});
	}//End newFile()
	
	/** Method to Edit **/
	
	public void editFile(){
			closePage();
			
		VBox editSideVBox = new VBox();
		editSideVBox.setId("sideVBox");
		editSideVBox.setMinHeight(400);
		editSideVBox.setMinWidth(180);
		
		ObservableList<String> items =
				FXCollections.observableArrayList(categoryNames);
		ComboBox<String> cboCategoryEdit = new ComboBox<>();
		cboCategoryEdit.setValue("Select");
		cboCategoryEdit.getItems().addAll(items);
		cboCategoryEdit.setId("cboCategory");
		editSideVBox.getChildren().add(cboCategoryEdit);
		stackVBoxPane.getChildren().add(editSideVBox);
		
		if(cboCategory.getValue() == "Academic"){
			
		}	
	}
	
	public void deleteFile(){
		
	}
	
	/*****************************************************************/
	
	public void favouriteFiles(){
		
	}
	
	/*****************************************************************/
	
	public void searchFile(){
		closePage();
		
		VBox searchSideVBox = new VBox();
		searchSideVBox.setId("sideVBox");
		searchSideVBox.setMinHeight(400);
		searchSideVBox.setMinWidth(180);
		searchSideVBox.setPadding(new Insets(20,10, 10, 10));
		ObservableList<String> items =
				FXCollections.observableArrayList(categoryNames);
		cboCategory.setValue("Select");
		cboCategory.getItems().addAll(items);
		cboCategory.setId("cboCategory");
		searchSideVBox.getChildren().add(cboCategory);
		stackVBoxPane.getChildren().add(searchSideVBox);
		
		if(cboCategory.getValue() == "Select"){
			
		}else if(cboCategory.getValue() == "Academic"){
			
			
		}else if(cboCategory.getValue() == "Social"){
			try{
				readFiles();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
	}
	
	/*****************************************************************/
	
	public void closePage(){
		functionPane.getChildren().clear();
		stackVBoxPane.getChildren().clear();
		
	}
	
	/*****************************************************************/
		
	public void saveFiles(Object obj) throws ClassNotFoundException, IOException{
		try(//Create an output stream for file object.dat
			ObjectOutputStream output =
				new ObjectOutputStream(new FileOutputStream("dataFiles.dat"));
		) {
			//Write a string, double and object to the file
			output.writeObject(obj);
		}
		
		try(//Create input stream for file object
				ObjectInputStream input =
				new ObjectInputStream(new FileInputStream("dataFiles.dat"));	
		) {
			//Read a string, double value, and object from the file
			PasswordAccount account = (PasswordAccount) input.readObject();
			
			System.out.println(account.getTitle());
			System.out.println(account.getUserName());
			System.out.println(account.getPassword());
		}
	}
	
	/*********************************************************************/
	
	public void readFiles() throws ClassNotFoundException, IOException{
		try(//Create input stream for file object
				ObjectInputStream input =
				new ObjectInputStream(new FileInputStream("dataFiles.dat"));	
		) {
			//Read a string, double value, and object from the file
			PasswordAccount account = (PasswordAccount) input.readObject();
			
			System.out.println(account.getTitle());
			System.out.println(account.getPassword());
		}
	}
	
	/**********************************************************************/
	
	public static void main(String[] args) {
		launch(args);
	}

}

