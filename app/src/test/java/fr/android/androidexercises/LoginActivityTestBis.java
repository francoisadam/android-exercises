package fr.android.androidexercises;

import junit.framework.TestCase;

import org.assertj.android.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

/**
 * Created by francois on 14/12/2016.
 */
@RunWith(CustomRobolectricTestRunner.class)
public class LoginActivityTestBis extends TestCase {
    LoginActivity activity;

    @Before
    public void testNotLogged() throws Exception {
        activity = Robolectric.setupActivity(LoginActivity.class);
    }


    @Test
    public void testLogged() throws Exception {
        activity.logged();
        Assertions.assertThat(activity.loginLayout).isGone();
         Assertions.assertThat(activity.loggedText).isVisible();
    }

}