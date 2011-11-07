package eric.com;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class LineageLogin extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        EditText userid = (EditText)findViewById(R.id.userid);
        EditText pw = (EditText)findViewById(R.id.pw);
        SharedPreferences setting = getSharedPreferences("lineage",MODE_PRIVATE);
		String uid = setting.getString("USERID", "");
		String passwd = setting.getString("PW", "");
		userid.setText(uid);
		pw.setText(passwd);
        

    }
    public void login (View v){
    	EditText userid = (EditText) findViewById(R.id.userid);
		EditText pw = (EditText) findViewById(R.id.pw);
		String uid = userid.getText().toString();
		String passwd = pw.getText().toString();
		Log.d("userid", uid);
		Log.d("pw", passwd);
		if (uid.equals("eric") && passwd.equals("1234")) {
			getSharedPreferences("lineage", MODE_PRIVATE).edit()
			.putString("USERID", uid)
			.putString("PW", passwd)
			.commit();
			new AlertDialog.Builder(this)
			.setTitle("登入成功")
			.setMessage("進入伺服器中請稍候")
			.setPositiveButton("確認", null)
			.show();
		} else {
			new AlertDialog.Builder(this)
			.setTitle("錯誤")
			.setMessage("登入失敗")
			.setPositiveButton("確認", null)
			.show();
		}
    }
}