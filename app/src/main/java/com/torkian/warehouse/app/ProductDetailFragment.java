package com.torkian.warehouse.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.torkian.warehouse.app.product.WarehouseContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A fragment representing a single Product detail screen.
 * This fragment is either contained in a {@link ProductListActivity}
 * in two-pane mode (on tablets) or a {@link ProductDetailActivity}
 * on handsets.
 */
public class ProductDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private WarehouseContent.ProductItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ProductDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = WarehouseContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_product_detail, container, false);


        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            if (mItem.content.equalsIgnoreCase("Exit"))
            {
                System.exit(1);
            }else if (mItem.content.equalsIgnoreCase("Add")){
                ((EditText)rootView.findViewById(R.id.editText)).setVisibility(View.VISIBLE);
                ((EditText)rootView.findViewById(R.id.editText2)).setVisibility(View.VISIBLE);
                ((EditText)rootView.findViewById(R.id.editText3)).setVisibility(View.VISIBLE);
                ((TextView)rootView.findViewById(R.id.textView)).setVisibility(View.VISIBLE);
                ((TextView)rootView.findViewById(R.id.textView2)).setVisibility(View.VISIBLE);
                ((TextView)rootView.findViewById(R.id.textView3)).setVisibility(View.VISIBLE);
                ((Button)rootView.findViewById(R.id.button)).setVisibility(View.VISIBLE);
                ((ListView)rootView.findViewById(R.id.listView)).setVisibility(View.INVISIBLE);



            }else if (mItem.content.equalsIgnoreCase("View")){
                ((EditText) rootView.findViewById(R.id.editText)).setVisibility(View.INVISIBLE);
                ((EditText) rootView.findViewById(R.id.editText2)).setVisibility(View.INVISIBLE);
                ((EditText) rootView.findViewById(R.id.editText3)).setVisibility(View.INVISIBLE);
                ((TextView) rootView.findViewById(R.id.textView)).setVisibility(View.INVISIBLE);
                ((TextView) rootView.findViewById(R.id.textView2)).setVisibility(View.INVISIBLE);
                ((TextView) rootView.findViewById(R.id.textView3)).setVisibility(View.INVISIBLE);
                ((Button)rootView.findViewById(R.id.button)).setVisibility(View.INVISIBLE);
                ((ListView)rootView.findViewById(R.id.listView)).setVisibility(View.VISIBLE);
                ListView listView = (ListView) rootView.findViewById(R.id.listView);
                String[] values = new String[] { "Android List View",
                        "Adapter implementation",
                        "Simple List View In Android",
                        "Create List View Android",
                        "Android Example",
                        "List View Source Code",
                        "List View Array Adapter",
                        "Android Example List View"
                };
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_1, android.R.id.text1, values);
                listView.setAdapter(adapter);



            }
            ((TextView) rootView.findViewById(R.id.product_detail)).setText(mItem.content);
        }

        return rootView;
    }

}
