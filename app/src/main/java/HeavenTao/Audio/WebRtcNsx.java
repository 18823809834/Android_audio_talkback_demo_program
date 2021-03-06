package HeavenTao.Audio;

import HeavenTao.Data.*;

//WebRtc定点版噪音抑制器类。
public class WebRtcNsx
{
    private long m_pvPoint; //WebRtc定点版噪音抑制器结构体的内存指针。

    static
    {
        System.loadLibrary( "Func" ); //加载libFunc.so。
        System.loadLibrary( "c++_shared" ); //加载libc++_shared.so。
        System.loadLibrary( "WebRtc" ); //加载libWebRtc.so。
    }

    //构造函数。
    public WebRtcNsx()
    {
        m_pvPoint = 0;
    }

    //析构函数。
    public void finalize()
    {
        Destory();
    }

    //获取WebRtc定点版噪音抑制器结构体的内存指针。
    public long GetPoint()
    {
        return m_pvPoint;
    }

    //创建并初始化WebRtc定点版噪音抑制器。
    public native long Init( int i32SamplingRate, long i64FrameLength, int i32PolicyMode );

    //用WebRtc定点版噪音抑制器对单声道16位有符号整型PCM格式帧进行WebRtc定点版噪音抑制。
    public native long Process( short pszi16Frame[], short pszi16ResultFrame[] );

    //销毁WebRtc定点版噪音抑制器。
    public native long Destory();
}
