//package ScenesGame;
//
//import org.newdawn.slick.GameContainer;
//import org.newdawn.slick.Graphics;
//import org.newdawn.slick.Image;
//import org.newdawn.slick.SlickException;
//import org.newdawn.slick.state.BasicGameState;
//import org.newdawn.slick.state.StateBasedGame;
//
//import Control.InputControl;
//import Graphics.Player;
//
//public class SingleGame extends BasicGameState {
//	private int ID;
//
//	Player p;
//	InputControl input;
//
//	Image back;
//	Image[][] block = new Image[18][32];
//
//	boolean[][] blockPosition = new boolean[18][32];
//
//	public SingleGame(int id) {
//		// TODO Auto-generated constructor stub
//		ID = id;
//	}
//
//	@Override
//	public void init(GameContainer container, StateBasedGame game) throws SlickException {
//		back = new Image("image/Gray.png");
//		for (int i = 0; i < block.length; i++)
//			for (int j = 0; j < block[i].length; j++)
//				block[i][j] = new Image("image/imsiBlock.png");
//
//		p = new Player(0, 0);
//		input = new InputControl(container);
//	}
//
//	@Override
//	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
//		back.draw();
//
//		int sizeX = 0;
//		int sizeY = 0;
//
//		for (int i = 0; i < block.length; i++) {
//			for (int j = 0; j < block[i].length; j++) {
//				if (i > 1 || j > 1) {
//					block[i][j].draw(0 + sizeX, sizeY);
//					blockPosition[i][j] = true;
//				}
//				sizeX += 40;
//			}
//			sizeY += 40;
//			sizeX = 0;
//		}
//
//		p.getCurrentAnimation().draw(p.getX(), p.getY());
//	}
//
//	@Override
//	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
//		p.move(input.getMessage());
//
//		if ((p.myXpoint() > 0 && p.myXpoint() < 32) && (p.myYpoint() > 0 && p.myYpoint() < 17))
//			if (p.hitBlock(input.getMessage()) == 1)
//				block[p.myYpoint() - 1][p.myXpoint()] = new Image("image/block2.png");
//			else if (p.hitBlock(input.getMessage()) == 2)
//				block[p.myYpoint() + 1][p.myXpoint()] = new Image("image/block2.png");
//			else if (p.hitBlock(input.getMessage()) == 3)
//				block[p.myYpoint()][p.myXpoint() - 1] = new Image("image/block2.png");
//			else if (p.hitBlock(input.getMessage()) == 4)
//				block[p.myYpoint()][p.myXpoint() + 1] = new Image("image/block2.png");
//
//		// 캐릭터의 현재 좌표 확인용
////		System.out.println(p.myXpoint() + " , " + p.myYpoint());
//
//	}
//
//	@Override
//	public int getID() {
//		// TODO Auto-generated method stub
//		return ID;
//	}
//
//}
