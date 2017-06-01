package com.site.util;

import java.util.Collection;
import java.util.List;

public class DataTable<T> {
	
	private int draw;
	private long recordsTotal;
	private long recordsFiltered;
	private Collection<?> data;
	
	public DataTable(Page<?> page){
		
		this.draw = page.getDraw();
		this.recordsTotal = page.getTotalElements();
		this.recordsFiltered = page.getTotalElements();
		this.data = page.getContent();
		
	}
	
	
	//depois remover este construtor
	public DataTable(int draw, long recordsTotal, long recordsFiltered,
			List<T> data) {
		
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
	}



	public int getDraw() {
		return draw;
	}



	public long getRecordsTotal() {
		return recordsTotal;
	}



	public long getRecordsFiltered() {
		return recordsFiltered;
	}



	public Collection<?> getData() {
		return data;
	}
	
	
	
	
	
	
	
	

}
