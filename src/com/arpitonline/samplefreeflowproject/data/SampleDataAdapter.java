package com.arpitonline.samplefreeflowproject.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arpitonline.samplefreeflowproject.R;
import com.arpitonline.samplefreeflowproject.views.HeaderView;
import com.arpitonline.samplefreeflowproject.views.ItemView;
import com.comcast.freeflow.core.FreeFlowItem;
import com.comcast.freeflow.core.Section;
import com.comcast.freeflow.core.SectionedAdapter;

public class SampleDataAdapter implements SectionedAdapter {

	
	private int sectionCount  = 10;
	private Section[] sections = new Section[sectionCount];
	
	public SampleDataAdapter() {
		for(int i=0; i<sectionCount; i++){
			Section s = new Section();
			s.setSectionTitle("Section "+i);
			for(int j=0; j< 5; j++){
				s.addItem( new Item("Item "+i+" / "+j ));
			}
			sections[i]  = s;
		}
	}

	@Override
	public long getItemId(int section, int position) {
		return section*100+position;
	}
	
	@Override
	public Class[] getViewTypes() {
		return new Class[]{HeaderView.class, ItemView.class};
	}

	@Override
	public Class getViewType(FreeFlowItem proxy) {
		if(proxy.data.getClass() == Item.class){
			return ItemView.class;
		}
		return HeaderView.class;
		
		
	}

	@Override
	public View getItemView(int section, int position, View convertView,
			ViewGroup parent) {
		if(convertView == null){
			convertView = LayoutInflater.from(parent.getContext()).inflate( R.layout.item, parent, false);
		}
		ItemView v = (ItemView)convertView;
		
		Item item = (Item)sections[section].getDataAtIndex(position);
		
		((TextView)v.findViewById(R.id.title)).setText(item.getLabel());
		return v;
	}

	@Override
	public View getHeaderViewForSection(int section, View convertView,
			ViewGroup parent) {
		
		if(convertView == null){
			convertView = LayoutInflater.from(parent.getContext()).inflate( R.layout.header, parent, false);
		}
		HeaderView v = (HeaderView)convertView;
		((TextView)v.findViewById(R.id.title)).setText(sections[section].getSectionTitle());
		return v;
		
	}

	@Override
	public int getNumberOfSections() {
		return sections.length;
	}

	@Override
	public Section getSection(int index) {
		return sections[index];
	}

	

	@Override
	public boolean shouldDisplaySectionHeaders() {
		return true;
	}
	
	public static class Item{
		private String s;
		public Item(String s){
			this.s = s;
		}
		
		public String getLabel(){
			return s;
		}
		
	}

}
