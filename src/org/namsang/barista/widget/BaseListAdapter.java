/**
 * Copyright 2012-present Namsang Labs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.namsang.barista.widget;

import java.util.ArrayList;
import java.util.List;

import kr.co.namsang.mb.barista.data.IndexPath;
import kr.co.namsang.mb.barista.io.ImageLoader;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class BaseListAdapter<T> extends BaseAdapter {		
    public static final String TAG = BaseListAdapter.class.getCanonicalName();

    protected Context context;
    protected LayoutInflater inflater;
    protected int resource; 

    protected List<T> listData = new ArrayList<T>();

    /**
     *	accessory view click listener
     */
    protected OnAccessoryViewClickListener onAccessoryViewClickListener = null;    

    public interface OnAccessoryViewClickListener {
    	public abstract void onAccessoryViewClick(int position);
    }

    public void setOnAccessoryViewClickListener(OnAccessoryViewClickListener listener) {
    	onAccessoryViewClickListener = listener;
    }    

    // 생성자
    public BaseListAdapter(Context context, int resource) {    	
        this.context = context;
        this.inflater = LayoutInflater.from(context);        
        this.resource = resource; 
        
        this.mImageLoader = new ImageLoader(context);
    }   
         
    public void setListData(List<T> listData) {    	
        this.listData = listData;
    }
    
    @Override
    public int getCount() {    	
        return listData.size();
    }

    @Override
    public T getItem(int position) {    	
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {    	
        return position;
    }

	@SuppressWarnings("unchecked")
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {    	
        ViewHolder holder;        
        
        if (convertView == null) {
            convertView = inflater.inflate(resource, parent, false);            
            holder = new ViewHolder();
            
            //holder.imageView = (ImageView)convertView.findViewById(kImageView);
            //holder.title = (TextView)convertView.findViewById(kTitleLabel);
            //holder.accesoryButton = (ImageButton)convertView.findViewById(kAccesoryButton); 
            //holder.accesoryButton.setTag((Integer)position);
              
            convertView.setTag(holder);            
        } 
        else {        	
            holder = (ViewHolder) convertView.getTag();
        }
        
        return convertView;
    }    
    
    public void accesoryButtonClicked(int position) {
    	// do nothing yet
    }
    
    public void reloadData() {    	
    	if (context instanceof Activity) {
	        ((Activity) context).runOnUiThread(new Runnable() {
	        	@Override
	            public void run() {
	                notifyDataSetChanged();
	            }   
	        });
    	}
    }	

    /**
     * 
     *
     */
    public class ViewHolder {    	
        public View imageView;
        public View accesoryView;
        public View cellContent;
        public TextView textLabel;
        public TextView detailTextLabel;      
    }  
    
    
    
    
    
    
    
    
    
    
    
    
    
    protected ImageLoader mImageLoader; 
    
    /**
     *	accessory view click listener
     */
    public OnCellClickListener onCellClickListener = null;    

    public interface OnCellClickListener 
    {
    	public abstract void onCellClick(final AdapterView<?> parent, final View view, final IndexPath indexPath);
    }

    public void setOnCellClickListener(OnCellClickListener listener) {
    	onCellClickListener = listener;
    }  
          
	
	public View getCellForRow(IndexPath indexPath, View convertView, ViewGroup parent) {
		return null;
	}
    
    
    public void displayImage(String url, ImageView imageView)
    {	
    	mImageLoader.displayImage(url, imageView);
    }
}