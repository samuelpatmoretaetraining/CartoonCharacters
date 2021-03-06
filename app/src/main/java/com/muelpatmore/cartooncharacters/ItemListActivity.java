package com.muelpatmore.cartooncharacters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.muelpatmore.cartooncharacters.data.DataManager;
import com.muelpatmore.cartooncharacters.data.event_bus.CharacterListReady;
import com.muelpatmore.cartooncharacters.data.event_bus.CharacterSelected;
import com.squareup.leakcanary.LeakCanary;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ItemListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        EventBus.getDefault().register(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(BuildConfig.application_name);
        if (getActionBar() != null) getActionBar().setTitle(BuildConfig.application_name);
        if (getSupportActionBar() != null) getSupportActionBar().setTitle(BuildConfig.application_name);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

        DataManager dataManager = new DataManager();
        dataManager.getCharacterList();

        recyclerView = findViewById(R.id.item_list);
        assert recyclerView != null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(CharacterListReady event) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, event.characterList, mTwoPane));
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final ItemListActivity mParentActivity;
        private final ArrayList<String> mValues;
        private final boolean mTwoPane;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView)view.findViewById(R.id.tvName);
                String item = (String) textView.getText();
                if(item != null) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(ItemDetailFragment.ARG_ITEM_ID, item);
                        ItemDetailFragment fragment = new ItemDetailFragment();
                        fragment.setArguments(arguments);
                        mParentActivity.getSupportFragmentManager().beginTransaction()
                                .replace(R.id.item_detail_container, fragment)
                                .commit();
                        EventBus.getDefault().post(new CharacterSelected(item));
                    } else {
                        Context context = view.getContext();
                        Intent intent = new Intent(context, ItemDetailActivity.class);
                        intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, item);

                        context.startActivity(intent);
                        EventBus.getDefault().post(new CharacterSelected(item));
                    }
                } else {
                    Toast.makeText(mParentActivity, "Name not loaded from view.", Toast.LENGTH_SHORT).show();
                }
            }
        };

        SimpleItemRecyclerViewAdapter(ItemListActivity parent,
                                      ArrayList<String> items,
                                      boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        /** {@inheritDoc} */
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_content, parent, false);
            return new ViewHolder(view);
        }

        /** {@inheritDoc} */
        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            String itemText = mValues.get(position);
            holder.tvName.setText(itemText.substring(0, itemText.indexOf("-")));
            holder.view.setOnClickListener(mOnClickListener);
        }

        /** {@inheritDoc} */
        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final View view;
            final TextView tvName;

            ViewHolder(View view) {
                super(view);
                this.view = view;
                tvName = (TextView) view.findViewById(R.id.tvName);
            }
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
