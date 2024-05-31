package integradoraM5;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;


@Suite
@SuiteDisplayName("Suite Test Integradora M5")
/*@SelectMethod(type = CuentaTest.class, name = "testRecuperaSaldo")*/
@SelectClasses({UsuarioTest.class})
public class SuiteTestIntegradoraM5 {

}
