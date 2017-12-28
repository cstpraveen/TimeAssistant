package com.prasilabs.timeassistant

import ai.api.AIListener
import ai.api.android.AIConfiguration
import ai.api.android.AIConfiguration.RecognitionEngine
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_task_list.*
import ai.api.android.AIService
import ai.api.model.AIError
import ai.api.model.AIResponse
import android.util.Log


class TaskListActivity : AppCompatActivity(), AIListener {

    var isListening = false

    val TAG = "TaskListActivity"

    override fun onResult(result: AIResponse?) {
        Log.i(TAG, "on Result Action: " + (result?.result?.action));

        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onListeningStarted() {
        Log.i(TAG, "listen started");

        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAudioLevel(level: Float) {
        Log.i(TAG, "audio level");

        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(error: AIError?) {
        Log.i(TAG, "on error");
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onListeningCanceled() {
        Log.i(TAG, "listen cancelled");
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onListeningFinished() {
        Log.i(TAG, "listen finished");
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val CLIENT_ACCESS_TOKEN = "dae8dcec99004782bb051b08d6d60b98";

    val config = AIConfiguration(CLIENT_ACCESS_TOKEN,
            ai.api.AIConfiguration.SupportedLanguages.English,
            RecognitionEngine.System)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val aiService = AIService.getService(this, config)
        aiService.setListener(this)

        setContentView(R.layout.activity_task_list)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            if(isListening)
                aiService.stopListening()
            else
                aiService.startListening()

            isListening = !isListening
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_task_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings ->
                return true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
