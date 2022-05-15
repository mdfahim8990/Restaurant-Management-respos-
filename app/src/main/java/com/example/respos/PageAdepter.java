package com.example.respos;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PageAdepter extends FragmentStateAdapter {
    public PageAdepter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new NewOrderFragment();
            case 1:
                return new InKitchenFragment();
            case 2:
                return new AllActiverOrdersFragment();
            case 3:
                return new TodaysOrderFragment();
            case 4:
                return new DeliveringFragment();
            case 5:
                return new DeliveredFragment();
            default:
                return new RejectedFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
