package lipan.top.notes.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年12月22日 17:09:00
 */
public class ToolUtrils {
    /**
     * 字符串转化为XML串
     *
     * @param str
     * @return
     * @throws Exception
     */
    public static String strChangeToXML(String str) {
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            document = saxReader.read(new ByteArrayInputStream(str.getBytes()));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        StringWriter writer = new StringWriter();
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UFT-8");
        XMLWriter xmlwriter = new XMLWriter(writer, format);
        try {
            xmlwriter.write(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }

    /**
     * 测试程序文件
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "<?xml version='1.0' encoding='UTF-8'?><GESInfo><City id='苏州' name='苏州' code='1001'><Area id='市区' name='市区' code='10011001' LocationSetup='0'><Place id='观前' name='观前' code='100110011001' LocationSetup='1'><Monitor id='摄像头1' name='摄像头1' code='11000000000000000011200034800000' gesid='abcde1' channelid='1' VideoScan='1' Capture='1' ManualREC='1' RecPlay ='1' MonControl='1' />        <Monitor id='摄像头2' name='摄像头2' code='11000000000000000011200034800000' gesid='abcde2' channelid='1' VideoScan='1' Capture='1' ManualREC='1' RecPlay ='1' MonControl='1' /></Place><Place id='石路' name='石路' code='100110011002' LocationSetup='2'><Monitor id='摄像头3' name='摄像头3' code='11000000000000000011200034800000' gesid='abcde3' channelid='1' VideoScan='1' Capture='1' ManualREC='1' RecPlay ='1' MonControl='1' />        <Monitor id='摄像头4' name='摄像头4' code='11000000000000000011200034800000' gesid='abcde4' channelid='1' VideoScan='1' Capture='1' ManualREC='1' RecPlay ='1' MonControl='1' /> </Place></Area><Area id='园区' name='园区' code='10011002' LocationSetup='0'><Place id='科技园' name='科技园' code='100110011003' LocationSetup='1'><Monitor id='摄像头5' name='摄像头5' code='11000000000000000011200034800000' gesid='abcde5' channelid='1' VideoScan='1' Capture='1' ManualREC='1' RecPlay ='1' MonControl='1' />        <Monitor id='摄像头6' name='摄像头6' code='11000000000000000011200034800000' gesid='abcde6' channelid='1' VideoScan='1' Capture='1' ManualREC='1' RecPlay ='1' MonControl='1' /> </Place><Place id='金鸡湖' name='金鸡湖' code='100110011004' LocationSetup='2'><Monitor id='摄像头7' name='摄像头7' code='11000000000000000011200034800000' gesid='abcde7' channelid='1' VideoScan='1' Capture='1' ManualREC='1' RecPlay ='1' MonControl='1' />        <Monitor id='摄像头8' name='摄像头8' code='11000000000000000011200034800000' gesid='abcde8' channelid='1' VideoScan='1' Capture='1' ManualREC='1' RecPlay ='1' MonControl='1' /> </Place></Area></City></GESInfo>";
        System.out.println(strChangeToXML(str));
    }
}
