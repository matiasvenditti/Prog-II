/**
 * Created by Matias on 28/10/2016.
 */
public class Online implements Estado {


    @Override
    public boolean isOnline() {
        return true;
    }

    @Override
    public boolean isOffline() {
        return false;
    }

    @Override
    public boolean isWorking() {
        return false;
    }
}
