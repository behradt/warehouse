package com.torkian.warehouse.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.torkian.warehouse.app.product.Product;
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
    public static List<Product> values = new ArrayList<Product>();

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
        final View rootView = inflater.inflate(R.layout.fragment_product_detail, container, false);


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



                Button button = (Button) rootView.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Do something in response to button click
                        Product currentProduct = new Product();

                        currentProduct.setId(((EditText) rootView.findViewById(R.id.editText)).getText().toString());
                        currentProduct.setName(((EditText) rootView.findViewById(R.id.editText2)).getText().toString());
                        currentProduct.setDis(((EditText) rootView.findViewById(R.id.editText3)).getText().toString());
                        values.add(currentProduct);

                        Toast.makeText(getActivity(), "Saved"+currentProduct.toString()+values.size(),
                                Toast.LENGTH_LONG).show();
                    }
                });



            }else if (mItem.content.equalsIgnoreCase("View")){
                Toast.makeText(getActivity(), "Total Product: "+values.size(),
                        Toast.LENGTH_LONG).show();
                ((EditText) rootView.findViewById(R.id.editText)).setVisibility(View.INVISIBLE);
                ((EditText) rootView.findViewById(R.id.editText2)).setVisibility(View.INVISIBLE);
                ((EditText) rootView.findViewById(R.id.editText3)).setVisibility(View.INVISIBLE);
                ((TextView) rootView.findViewById(R.id.textView)).setVisibility(View.INVISIBLE);
                ((TextView) rootView.findViewById(R.id.textView2)).setVisibility(View.INVISIBLE);
                ((TextView) rootView.findViewById(R.id.textView3)).setVisibility(View.INVISIBLE);
                ((Button)rootView.findViewById(R.id.button)).setVisibility(View.INVISIBLE);
                ((ListView)rootView.findViewById(R.id.listView)).setVisibility(View.VISIBLE);
                ListView listView = (ListView) rootView.findViewById(R.id.listView);
                ArrayAdapter<Product> adapter = new ArrayAdapter<Product>(getActivity(),
                        android.R.layout.simple_list_item_1, android.R.id.text1, values);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Toast.makeText(getActivity(),
                                "Click ListItem Number " + position, Toast.LENGTH_LONG)
                                .show();
                    }
                });




            }
            ((TextView) rootView.findViewById(R.id.product_detail)).setText(mItem.content);
        }

        return rootView;
    }

}
