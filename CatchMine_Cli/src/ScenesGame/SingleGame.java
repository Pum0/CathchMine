package ScenesGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Control.InputControl;
import Graphics.Player;
import Graphics.blockBase;

public class SingleGame extends BasicGameState {
	private int ID;

	Player p;
	InputControl input;

	blockBase b;
	Image back;
	Image[][] block = new Image[18][32];

	public SingleGame(int id) {
		// TODO Auto-generated constructor stub
		ID = id;
	}

	private int siGan = 0;

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		back = new Image("image/Gray.png");

		p = new Player(0, 0);
		input = new InputControl(container);
		b = new blockBase();

		b.initBlock(block);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

		back.draw();

		b.disposeBlock(block);

		p.getCurrentAnimation().draw(p.getX(), p.getY());

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

		p.move(input.getMessage(), b);

		if (p.myYpoint() > 0 && p.myYpoint() < 17) {
			if (p.hitBlock(input.getMessage()) == 1) { // �� ����Ű �Է����� 1ĭ ���� ��ϰ� ��ȣ�ۿ�
				b.decHp(p.myYpoint() - 1, p.myXpoint());

				if (b.getBlockStack(p.myYpoint() - 1, p.myXpoint()) == 2)
					block[p.myYpoint() - 1][p.myXpoint()] = new Image("image/imsiBlock1.png");
				else if (b.getBlockStack(p.myYpoint() - 1, p.myXpoint()) == 1)
					block[p.myYpoint() - 1][p.myXpoint()] = new Image("image/imsiBlock2.png");
				else if (b.getBlockStack(p.myYpoint() - 1, p.myXpoint()) <= 0)
					block[p.myYpoint() - 1][p.myXpoint()] = new Image("image/Gray.png");

			} else if (p.hitBlock(input.getMessage()) == 2) { // �Ʒ� ����Ű �Է����� 1ĭ �Ʒ� ��ϰ� ��ȣ�ۿ�
				b.decHp(p.myYpoint() + 1, p.myXpoint());

				if (b.getBlockStack(p.myYpoint() + 1, p.myXpoint()) == 2)
					block[p.myYpoint() + 1][p.myXpoint()] = new Image("image/imsiBlock1.png");
				else if (b.getBlockStack(p.myYpoint() + 1, p.myXpoint()) == 1)
					block[p.myYpoint() + 1][p.myXpoint()] = new Image("image/imsiBlock2.png");
				else if (b.getBlockStack(p.myYpoint() + 1, p.myXpoint()) <= 0)
					block[p.myYpoint() + 1][p.myXpoint()] = new Image("image/Gray.png");

			}
		}
		if ((p.myXpoint() > 0 && p.myXpoint() < 32))

		{
			if (p.hitBlock(input.getMessage()) == 3)

			{ // ���� ����Ű �Է����� 1ĭ ���� ��ϰ� ��ȣ�ۿ�
				b.decHp(p.myYpoint(), p.myXpoint() - 1);

				if (b.getBlockStack(p.myYpoint(), p.myXpoint() - 1) == 2)
					block[p.myYpoint()][p.myXpoint() - 1] = new Image("image/imsiBlock1.png");
				else if (b.getBlockStack(p.myYpoint(), p.myXpoint() - 1) == 1)
					block[p.myYpoint()][p.myXpoint() - 1] = new Image("image/imsiBlock2.png");
				else if (b.getBlockStack(p.myYpoint(), p.myXpoint() - 1) <= 0)
					block[p.myYpoint()][p.myXpoint() - 1] = new Image("image/Gray.png");

			} else if (p.hitBlock(input.getMessage()) == 4) { // ������ ����Ű �Է����� 1ĭ ������ ��ϰ� ��ȣ�ۿ�
				b.decHp(p.myYpoint(), p.myXpoint() + 1);

				if (b.getBlockStack(p.myYpoint(), p.myXpoint() + 1) == 2)
					block[p.myYpoint()][p.myXpoint() + 1] = new Image("image/imsiBlock1.png");
				else if (b.getBlockStack(p.myYpoint(), p.myXpoint() + 1) == 1)
					block[p.myYpoint()][p.myXpoint() + 1] = new Image("image/imsiBlock2.png");
				else if (b.getBlockStack(p.myYpoint(), p.myXpoint() + 1) <= 0)
					block[p.myYpoint()][p.myXpoint() + 1] = new Image("image/Gray.png");

			}
		}

		System.out.println(
				"�� X�� : " + b.getX(p.myYpoint(), p.myXpoint()) + "\n�� Y�� : " + b.getY(p.myYpoint(), p.myXpoint()));
		// ĳ������ ���� ��ǥ Ȯ�ο�
		System.out.println(p.myYpoint() + " , " + p.myXpoint());

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

}
