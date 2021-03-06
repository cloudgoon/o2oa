package com.x.attendance.assemble.control.jaxrs.attendancestatistic;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.x.attendance.assemble.control.Business;
import com.x.attendance.entity.StatisticUnitForDay;
import com.x.base.core.container.EntityManagerContainer;
import com.x.base.core.container.factory.EntityManagerContainerFactory;
import com.x.base.core.entity.JpaObject;
import com.x.base.core.project.bean.WrapCopier;
import com.x.base.core.project.bean.WrapCopierFactory;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;

public class ActionShowStdForUnitWithDate extends BaseAction {
	
	private static  Logger logger = LoggerFactory.getLogger( ActionShowStdForUnitWithDate.class );
	
	protected ActionResult<List<Wo>> execute( HttpServletRequest request, EffectivePerson effectivePerson, String unitName, String date ) throws Exception {
		ActionResult<List<Wo>> result = new ActionResult<>();
		List<Wo> wraps = null;
		Business business = null;
		List<String> ids = null;
		List<StatisticUnitForDay> statisticUnitForDay_list = null;
		List<String> unitNames = null;
		
		if ("(0)".equals(unitName)) {
			unitName = null;
		}
		if ("(0)".equals(date)) {
			date = null;
		}
		try (EntityManagerContainer emc = EntityManagerContainerFactory.instance().create()) {
			business = new Business(emc);
			if( unitName != null && !unitName.isEmpty()){
				try{
					unitNames = userManagerService.listSubUnitNameWithParent( unitName );
					if( unitNames == null ) {
						unitNames = new ArrayList<>();
						unitNames.add( unitName );
					}
				}catch(Exception e){
					logger.error( e, effectivePerson, request, null);
				}
			}
			try{
				ids = business.getStatisticUnitForDayFactory().listByUnitDayDate( unitNames, date );
			}catch(Exception e){
				logger.error( e, effectivePerson, request, null);
			}
			try{
				if( ids != null && !ids.isEmpty() ){
					statisticUnitForDay_list = business.getStatisticUnitForDayFactory().list(ids);
				}
			}catch(Exception e){
				logger.error( e, effectivePerson, request, null);
			}
			try{
				if( statisticUnitForDay_list != null && !statisticUnitForDay_list.isEmpty() ){
					wraps = Wo.copier.copy( statisticUnitForDay_list );
					result.setData(wraps);
				}
			}catch(Exception e){
				logger.error( e, effectivePerson, request, null);
			}		
		} catch (Exception e) {
			result.error( e );
		}
		return result;
	}

	public static class Wo extends StatisticUnitForDay  {
		
		private static final long serialVersionUID = -5076990764713538973L;		
		
		public static WrapCopier<StatisticUnitForDay, Wo> copier = 
				WrapCopierFactory.wo( StatisticUnitForDay.class, Wo.class, null, JpaObject.FieldsInvisible);
	}
}