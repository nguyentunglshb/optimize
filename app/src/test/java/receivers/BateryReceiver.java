package receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import models.Batery;

public class BateryReceiver extends BroadcastReceiver {
    private final MutableLiveData<Batery> batery = new MutableLiveData<>();

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }

        final Batery battery = configs.Batery.getBattery(intent);

        this.batery.postValue(battery);
    }

    public LiveData<Batery> getBattery() {
        return batery;
    }
}
