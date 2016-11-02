package com.example.kantai.vieweaxmple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kantai on 2016/11/3.
 */

// 自建一個 PostAdapter(轉接器)，並繼承 BaseAdapter
public class PostAdapter extends BaseAdapter {

    protected int cellLayout;
    protected LayoutInflater layoutInflater;
    protected List<Post> postList = new ArrayList<>();

    public PostAdapter(Context context) {
        if (context.getClass().equals(listViewActivity.class))
            this.cellLayout = R.layout.activity_list_view_cell;
        else
            this.cellLayout = R.layout.activity_grid_view_cell;

        this.layoutInflater = LayoutInflater.from(context);
        // 利用 for 迴圈去建造 50 筆資料
        for (int i = 0; i < 50; i++)
            postList.add(new Post(R.mipmap.ic_launcher, i, "Hello World!"));
    }

    // (1)複寫長度方法
    @Override
    public int getCount() {
        // 回傳 Post(Cell) 的長度
        return postList.size();
    }

    // (2)複寫取得 Post(Cell) 的方法
    @Override
    public Object getItem(int position) {
        // 回傳目標 Post(Cell)，例如被點到10號 Post(Cell)，就會回傳 postList.get(10))
        // 像 onItemClick 事件的 (... int position ...)
        return postList.get(position);
    }

    // (3)複寫取得 Post(Cell) 編號的方法
    @Override
    public long getItemId(int position) {
        // 回傳目標 Post(Cell) 的編號，例如被點到 10 號 Post(Cell)，就會回傳 10 號
        // 像 onItemClick 事件的 (... long id)
        return postList.get(position).getArg();
    }

    // (4)複寫取得目標 Post(Cell) 畫面(Item View) 的方法
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 如果 convertView 是空的
        if (convertView == null)
            // 就給它一個 View，這個 View 是自訂的 activity_list_view_cell
            convertView = layoutInflater.inflate(this.cellLayout, parent, false);

        // 取得目標 Post 的資料
        Post post = postList.get(position);

        // 抓取 convertView 的 ImageView，並指定它顯示的圖片
        ((ImageView) convertView.findViewById(R.id.activity_list_view_cell_imageView)).setImageResource(post.getImage());

        // 抓取 convertView 的 TextView(Arg)，並指定它顯示的內容
        ((TextView) convertView.findViewById(R.id.activity_list_view_cell_arg)).setText(String.valueOf(post.getArg()));

        // 抓取 convertView 的 TextView(Name)，並指定它顯示的內容
        ((TextView) convertView.findViewById(R.id.activity_list_view_cell_name)).setText(post.getName());

        // 將整個 convertView 回傳
        return convertView;
    }
}


// 存放資料的種子
class Post {
    // 定義 ImageView 的 R.id
    protected int imageId;
    // 定義 TextView(Arg) 的值
    protected int arg;
    // 定義 TextView(Name) 的值
    protected String name;

    public Post(int imageId, int arg, String name) {
        this.setImage(imageId);
        this.setArg(arg);
        this.setName(name);
    }

    public int getImage() {
        return this.imageId;
    }

    public int getArg() {
        return this.arg;
    }

    public String getName() {
        return this.name;
    }

    private void setImage(int imageId) {
        this.imageId = imageId;
    }

    private void setArg(int arg) {
        this.arg = arg;
    }

    private void setName(String name) {
        this.name = name;
    }
}