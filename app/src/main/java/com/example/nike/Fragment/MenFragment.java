package com.example.nike.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nike.Adapter.CategoryAdapter;
import com.example.nike.Adapter.NewProductAdapter;
import com.example.nike.Model.Category;
import com.example.nike.Model.NewProduct;
import com.example.nike.R;

import java.util.ArrayList;
import java.util.List;


public class MenFragment extends Fragment {

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    private List<Category> categoryList;
    private RecyclerView recyclerViewNewProducts;
    private NewProductAdapter newProductAdapter;
    private List<NewProduct> newProductList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_men, container, false);

        Anhxa(view);

        setDataRCVcategory();
        setDataRCVnewShoes();

        return view;

    }
    private void setDataRCVcategory(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false ));

        categoryList = new ArrayList<>();
        categoryList.add(new Category(R.drawable.nike_dunk));
        categoryList.add(new Category(R.drawable.nike_airjordan1));
        categoryList.add(new Category(R.drawable.nike_cortez));
        categoryList.add(new Category(R.drawable.nike_airforce1));
        categoryList.add(new Category(R.drawable.nike_blazer));
        categoryList.add(new Category(R.drawable.nike_skillshot));


        categoryAdapter = new CategoryAdapter(categoryList);
        recyclerView.setAdapter(categoryAdapter);
    }
    private void setDataRCVnewShoes(){

        recyclerViewNewProducts.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        newProductList = new ArrayList<>();
        newProductList.add(new NewProduct(R.drawable.nike_vaporfly_3_electric, "Nike Vaporfly 3 Electric"));
        newProductList.add(new NewProduct(R.drawable.nike_infinityrn_4_electric, "Nike Infinityrn 4 Electric"));
        newProductList.add(new NewProduct(R.drawable.nike_invicible_3_electric, "Nike Invicible 3 Electric"));
        newProductList.add(new NewProduct(R.drawable.nike_pegasus_41_electric, "Nike Pegasus 41 Electric"));
        newProductList.add(new NewProduct(R.drawable.phantom_gx_2_academy_easyon_electric, "Phantom 2 Esyon Electric"));
        newProductList.add(new NewProduct(R.drawable.phantom_luna_2_elite_electric, "Phantom Luna 2 Elite Electric"));

        newProductAdapter = new NewProductAdapter(newProductList);
        recyclerViewNewProducts.setAdapter(newProductAdapter);
    }

    private void Anhxa(View view){
        recyclerView = view.findViewById(R.id.recyclerView_category);
        recyclerViewNewProducts = view.findViewById(R.id.recyclerViewNewProducts);
    }

}