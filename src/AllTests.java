
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ TestAdd.class, TestDelete.class, TestReplace.class, TestFetch.class, TestFetchComplete.class })

public class AllTests {

}
