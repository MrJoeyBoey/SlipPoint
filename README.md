# SlipPoint
    1. 添加依赖 
    -------  
        

Step 1. Add the JitPack repository to your build file
        Add it in your root build.gradle at the end of repositories:
        
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.MrJoeyBoey:SlipPoint:1.1'
	}
  
    2. 使用方法 
    -------  
    I.在.xml文件中添加
    
    <com.example.slippointlibrary.SlipPoint
      android:id="@+id/slippoint"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content">
    </com.example.slippointlibrary.SlipPoint>
    
    可设置属性 app:point_size="20" 用来改变点的大小
    
    
    II.在.java文件中添加
    SlipPoint slipPoint=findViewById(R.id.slippoint);
    可设置属性：
    slipPoint.bindViewPager(viewPager,adapter);
    slipPoint
             //.setNum(7)
             .setDelayTime(2000)
             .setAutoSlide(true)
             .create();
    
    
