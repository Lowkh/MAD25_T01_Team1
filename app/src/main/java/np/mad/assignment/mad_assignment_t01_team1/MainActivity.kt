package np.mad.assignment.mad_assignment_t01_team1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import np.mad.assignment.mad_assignment_t01_team1.data.db.AppDatabase
import np.mad.assignment.mad_assignment_t01_team1.data.db.seedMockData
import np.mad.assignment.mad_assignment_t01_team1.ui.theme.MAD_Assignment_T01_Team1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Check session: if no logged-in user, open LoginActivity
        val authPrefs = getSharedPreferences("auth", MODE_PRIVATE)
        val loggedInUserId = authPrefs.getLong("logged_in_user", -1L)
        if (loggedInUserId == -1L) {
            // No user saved: launch LoginActivity and finish MainActivity
            startActivity(android.content.Intent(this, LoginActivity::class.java))
            finish()
            return
        }
        enableEdgeToEdge()
        setContent {
            MAD_Assignment_T01_Team1Theme{
                MainNavigation(
                    userId = loggedInUserId,
                )
            }
        }
    }
}
