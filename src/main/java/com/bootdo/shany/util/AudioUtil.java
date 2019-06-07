package com.bootdo.shany.util;

import org.json.JSONArray;
import org.json.JSONObject;

import com.iflytek.cloud.speech.RecognizerListener;
import com.iflytek.cloud.speech.RecognizerResult;
import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechRecognizer;
import com.iflytek.cloud.speech.SpeechSynthesizer;
import com.iflytek.cloud.speech.SpeechUtility;
import com.iflytek.cloud.speech.SynthesizerListener;

public class AudioUtil {

		private static String buf;

		//合成监听器
		private static SynthesizerListener mSynListener = new SynthesizerListener(){
		    //会话结束回调接口，没有错误时，error为null
		    public void onCompleted(SpeechError error) {}
		    //缓冲进度回调
		    //percent为缓冲进度0~100，beginPos为缓冲音频在文本中开始位置，endPos表示缓冲音频在文本中结束位置，info为附加信息。
		    public void onBufferProgress(int percent, int beginPos, int endPos, String info) {}
		    //开始播放
		    public void onSpeakBegin() {}
		    //暂停播放
		    public void onSpeakPaused() {}
		    //播放进度回调
		    //percent为播放进度0~100,beginPos为播放音频在文本中开始位置，endPos表示播放音频在文本中结束位置.
		    public void onSpeakProgress(int percent, int beginPos, int endPos) {}
		    //恢复播放回调接口
		    public void onSpeakResumed() {}
			@Override
			public void onEvent(int arg0, int arg1, int arg2, int arg3, Object arg4, Object arg5) {
			}
		};

		//语音识别器
		private static RecognizerListener mRecoListener = new RecognizerListener(){
		    //听写结果回调接口(返回Json格式结果，用户可参见附录)；
		    //一般情况下会通过onResults接口多次返回结果，完整的识别内容是多次结果的累加；
		    //关于解析Json的代码可参见MscDemo中JsonParser类；
		    //isLast等于true时会话结束。
		    public void onResult(RecognizerResult results, boolean isLast){
//		        DebugLog.debug("Result:"+results.getResultString ());
		    	buf+=parseIatResult(results.getResultString ());
		    	System.out.println("Result:"+buf);
		    }
		    //会话发生错误回调接口
		    public void onError(SpeechError error) {
		        error.getErrorDescription(true); //获取错误码描述
		    }
		    //开始录音
		    public void onBeginOfSpeech() {}
		    //音量值0~30
		    public void onVolumeChanged(int volume){}
		    //结束录音
		    public void onEndOfSpeech() {}
		    //扩展用接口
		    public void onEvent(int eventType,int arg1,int arg2,String msg) {}
		};

		//将传入的文字播放
		public static void audioPlayer( String info) {
			SpeechUtility.createUtility( SpeechConstant.APPID +"=59aab9b4");
			//1.创建SpeechSynthesizer对象
			SpeechSynthesizer mTts= SpeechSynthesizer.createSynthesizer( );
			//2.合成参数设置，详见《MSC Reference Manual》SpeechSynthesizer 类
			mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");//设置发音人
			mTts.setParameter(SpeechConstant.SPEED, "50");//设置语速
			mTts.setParameter(SpeechConstant.VOLUME, "80");//设置音量，范围0~100
			//设置合成音频保存位置（可自定义保存位置），保存在“./tts_test.pcm”
			//如果不需要保存合成音频，注释该行代码
			mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, "./tts_test.pcm");
			//3.开始合成
			if(info!=null&&!"".equals(info)) {
				//System.out.println("[READ]:"+info);
				mTts.startSpeaking(info, mSynListener);
			}
		}

		public static String parseIatResult(String json) {
			StringBuffer ret = new StringBuffer();
			try {
//				JSONTokener tokener = new JSONTokener(json);
				JSONObject joResult = new JSONObject(json);

				JSONArray words = joResult.getJSONArray("ws");
				for (int i = 0; i < words.length(); i++) {
					// 转写结果词，默认使用第一个结果
					JSONArray items = words.getJSONObject(i).getJSONArray("cw");
					JSONObject obj = items.getJSONObject(0);
					ret.append(obj.getString("w"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ret.toString();
		}


		public static String audioListen() {
			SpeechUtility.createUtility( SpeechConstant.APPID +"=59aab9b4");
			SpeechRecognizer mIat= SpeechRecognizer.createRecognizer( );
			//1.创建SpeechRecognizer对象
			//2.设置听写参数，详见《MSC Reference Manual》SpeechConstant类
			mIat.setParameter(SpeechConstant.DOMAIN, "iat");
			mIat.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
			mIat.setParameter(SpeechConstant.ACCENT, "mandarin ");
			//3.开始听写
			mIat.startListening(mRecoListener);
			//听写监听器
			return buf;
		}

		public static void main(String[] args) {
			// System.out.println("[out]:"+audioListen());
			// AudioUtil.audioPlayer("大家好我叫杨璠，今年午睡了");
		}
}
