package com.muelpatmore.cartooncharacters;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.muelpatmore.cartooncharacters.data.DataManager;
import com.muelpatmore.cartooncharacters.data.event_bus.CharacterDetailsReady;
import com.muelpatmore.cartooncharacters.data.event_bus.CharacterListReady;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {

    private DataManager dataManager;

    private TextView item_detail;
    public static final String ARG_ITEM_ID = "item_id";
    private String name;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
        dataManager = new DataManager();
        EventBus.getDefault().register(this);
    }

    /** {@inheritDoc} */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            name = getArguments().getString(ARG_ITEM_ID).toString();

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(name);
            }
            dataManager.getCharacterDetails(name);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(CharacterDetailsReady event) {
        item_detail.setText(event.character.getText());
    }

    /** {@inheritDoc} */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        item_detail = (TextView) rootView.findViewById(R.id.item_detail);

        // Show the dummy content as text in a TextView.
        if (name != null) {
            item_detail.setText(name);
        }

        return rootView;
    }


    /** {@inheritDoc}
     * Note: also unregisters from EventBus.
     */
    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
