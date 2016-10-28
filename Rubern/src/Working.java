/**
 * Created by Matias on 28/10/2016.
 */
public class Working implements Estado {
    @Override
    public boolean isOnline() {
        return false;
    }

    @Override
    public boolean isOffline() {
        return false;
    }

    @Override
    public boolean isWorking() {
        return true;
    }
}
