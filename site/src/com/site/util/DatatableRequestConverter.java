package com.site.util;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.Converter;



@Convert(PageRequest.class)
@RequestScoped
public class DatatableRequestConverter implements Converter<PageRequest> {
	
	
	@Inject
	private  HttpServletRequest request;

	
	

	public DatatableRequestConverter() {
		
	}




	@Override
	public PageRequest convert(String value, Class<? extends PageRequest> type) {
        String iDraw = this.request.getParameter("draw");
		String iDisplayStart = this.request.getParameter("start");
		String iDisplayLength = this.request.getParameter("length");

		Integer start = Integer.valueOf(iDisplayStart);
		Integer size = Integer.valueOf(iDisplayLength);
		
		Integer draw = Integer.valueOf(iDisplayLength);
		
		String search = this.request.getParameter("search[value]");

		PageRequest pageRequest = new PageRequest();

		pageRequest.setStart(start);
		pageRequest.setSize(size);
		pageRequest.setSearch(search);

		return pageRequest;
	}


}
