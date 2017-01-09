package event;

import java.util.EventListener;

public interface SRTEventListener extends EventListener{

	public void gesturePerformed(SRTEvent e);
}
