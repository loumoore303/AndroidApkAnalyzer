package sk.styk.martin.apkanalyzer.ui.activity.appdetail.page.activity

import sk.styk.martin.apkanalyzer.model.detail.ActivityData
import sk.styk.martin.apkanalyzer.util.AppDetailDataExchange

class ActivityDetailPagePresenter : ActivityDetailPageContract.Presenter {

    override lateinit var view: ActivityDetailPageContract.View
    private lateinit var activityData: List<ActivityData>

    override fun initialize(packageName : String) {
        this.activityData = AppDetailDataExchange.get(packageName)?.activityData ?: emptyList()
    }

    override fun getData() {
        view.showData()
    }

    override fun itemCount(): Int = activityData.size

    override fun onBindViewOnPosition(position: Int, holder: ActivityDetailPageContract.ItemView) {
        holder.bind(activityData[position])
    }

    override fun runActivity(position: Int) {

        view.startForeignActivity(
                packageName = activityData[position].packageName ?: return,
                activityName = activityData[position].name
        )
    }
}