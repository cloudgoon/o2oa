package o2.collect.assemble.jaxrs.unexpectederrorlog;

import java.util.List;

import com.x.base.core.entity.JpaObject;
import com.x.base.core.project.bean.WrapCopier;
import com.x.base.core.project.bean.WrapCopierFactory;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;

import o2.collect.core.entity.log.UnexpectedErrorLog;

class ActionListPrev extends BaseAction {

	ActionResult<List<Wo>> execute(EffectivePerson effectivePerson, String id, Integer count) throws Exception {
		ActionResult<List<Wo>> result = new ActionResult<>();
		result = this.standardListPrev(Wo.copier, id, count, JpaObject.sequence_FIELDNAME, null, null, null, null, null,
				null, null, null, true, DESC);
		return result;
	}

	public static class Wo extends UnexpectedErrorLog {

		private static final long serialVersionUID = 6060455361328632654L;

		static WrapCopier<UnexpectedErrorLog, Wo> copier = WrapCopierFactory.wo(UnexpectedErrorLog.class, Wo.class,
				JpaObject.singularAttributeField(UnexpectedErrorLog.class, true, true), null);

		private Long rank;

		public Long getRank() {
			return rank;
		}

		public void setRank(Long rank) {
			this.rank = rank;
		}

	}
}
