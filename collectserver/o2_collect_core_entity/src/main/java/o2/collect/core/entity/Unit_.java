/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package o2.collect.core.entity;

import com.x.base.core.entity.SliceJpaObject_;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=o2.collect.core.entity.Unit.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Sat Aug 25 23:06:36 CST 2018")
public class Unit_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<Unit,String> centerContext;
    public static volatile SingularAttribute<Unit,String> centerHost;
    public static volatile SingularAttribute<Unit,Integer> centerPort;
    public static volatile ListAttribute<Unit,String> controllerMobileList;
    public static volatile SingularAttribute<Unit,String> httpProtocol;
    public static volatile SingularAttribute<Unit,String> id;
    public static volatile SingularAttribute<Unit,String> name;
    public static volatile SingularAttribute<Unit,String> password;
    public static volatile SingularAttribute<Unit,String> pinyin;
    public static volatile SingularAttribute<Unit,String> pinyinInitial;
}