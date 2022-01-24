import org.junit.*;

public class MainClassTest {
//    @BeforeClass
//    public void beforeClassMethod() {
//
//    }
//
//    @Before
//    public void setUp() {
//
//    }

    @Test
    public void method1() {
        Assert.assertTrue("Value are not true!", 1 + 1 == 2);
    }

    @Test
    public void method2() {
        Assert.assertFalse("Value are true!",1 + 1 == 2);
    }

    @Test
    public void method3() {
        Assert.assertEquals(11, 5 + 5);
    }

    @Test
    public void method4() {
        Assert.assertNotEquals(11, 5 + 5);
    }

//    @After
//    public void tearDown() {
//
//    }
//
//    @AfterClass
//    public void afterClassMethod() {
//
//    }
}
