package np.mad.assignment.mad_assignment_t01_team1.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "stalls",
    [Index("canteenId"), Index("name")],
    foreignKeys = [
        ForeignKey(
            CanteenEntity::class,
            ["canteenId"],
            ["canteenId"],
            ForeignKey.CASCADE
        )
    ]
)
data class StallEntity(
    @PrimaryKey(autoGenerate = true) val stallId: Long = 0,
    val canteenId: Long,
    val name: String,
    val imageUrl: String? = null,
    val halal: Boolean = false
)