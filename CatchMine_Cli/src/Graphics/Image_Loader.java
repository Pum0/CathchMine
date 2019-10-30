package Graphics;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Image_Loader extends SlickException {

	
	public Image_Loader(String message, Throwable e) {
		super(message, e);
		// TODO Auto-generated constructor stub
	}

	Image BackImage;
	Image loginButton, exit, loginButton1, exit1;
	
	// login title
//	public Image BackImage = new Image("image/main_Image1.png");
//	public Image loginButton = new Image("image/button/loginButton.png");
//	public Image loginButton1 = new Image("image/button/loginButton1.png");
//	public Image exit = new Image("image/button/big_exit.png");
//	public Image exit1 = new Image("image/button/big_exit1.png");


	// LoadMethods
	// ===============================================================================

	public void LoadGameResource() throws SlickException {
		
	}

	public void LoadMenuResource() throws SlickException {
		BackImage = new Image("image/main_Image1.png");

		loginButton = new Image("image/button/loginButton.png");
		loginButton1 = new Image("image/button/loginButton1.png");
		exit = new Image("image/button/big_exit.png");
		exit1 = new Image("image/button/big_exit1.png");
		
//		single = new Image("image/button/big_single.png");
	}

}