package mp.animation;

import mp.interfaces.AvatarInterface;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags({"Animator"})
public class Animator implements AnimatorInterface{
	protected static final long sleepTime = 100;
	protected static final int flat = 180, angle = 60, jumps = 15;
	protected boolean up = false;
	protected AvatarInterface avatar;
	
	public Animator(AvatarInterface avatar) {
		this.avatar = avatar;
	}
	
	@Tags({"animateAvatar"})
	public synchronized void dance() {
		for(int i = 0; i < jumps; i++) {
			if(up) {
				avatar.getArms().getLeftLine().setAngle(flat);
				avatar.getArms().getRightLine().setAngle(0);
				up = false;
			} else {
				avatar.getArms().getLeftLine().setAngle(flat-angle);
				avatar.getArms().getRightLine().setAngle(angle);
				up = true;
			}
			ThreadSupport.sleep(sleepTime);
		}
	}
}
