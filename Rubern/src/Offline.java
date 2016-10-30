/**
 * Created by Matias on 28/10/2016.
 */
public class Offline implements Estado {
    @Override
    public boolean isOnline() {
        return false;
    }

    @Override
    public boolean isOffline() {
        return true;
    }

    @Override
    public boolean isWorking() {
        return false;
    }
    @Override
    public String toString(){
        return "Offline.";
    }
}
