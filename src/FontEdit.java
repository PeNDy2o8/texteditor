import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zx328
 */
public class FontEdit implements ActionListener {
   static JMenuItem blue,red,pink, standard, microsoftBold, newDetail;
    JTextPane textPane;
    public FontEdit(JTextPane jtextPane){
    textPane=jtextPane;
    createItem();
    }
    public void createItem(){
        blue = new JMenuItem("藍色");
        red = new JMenuItem("紅色");
        pink = new JMenuItem("粉紅色");
        blue.addActionListener(this);
        red.addActionListener(this);
        pink.addActionListener(this);

        standard = new JMenuItem("標楷體");
        standard.addActionListener(this);
        microsoftBold = new JMenuItem("微軟正黑體");
        microsoftBold.addActionListener(this);
        newDetail = new JMenuItem("新細明體");
        newDetail.addActionListener(this);
    }
    public static final void setCharacterAttributes(JEditorPane editor,
                                                    AttributeSet attr, boolean replace) {
        int p0 = editor.getSelectionStart();
        int p1 = editor.getSelectionEnd();
        if (p0 != p1) {
            StyledDocument doc = getStyledDocument(editor);
            doc.setCharacterAttributes(p0, p1 - p0, attr, replace);
        }
        StyledEditorKit k = getStyledEditorKit(editor);
        MutableAttributeSet inputAttributes = k.getInputAttributes();
        if (replace) {
            inputAttributes.removeAttributes(inputAttributes);
        }
        inputAttributes.addAttributes(attr);
    }protected static final StyledEditorKit getStyledEditorKit(JEditorPane e) {
        EditorKit k = e.getEditorKit();
        if (k instanceof StyledEditorKit) {
            return (StyledEditorKit) k;
        }
        throw new IllegalArgumentException("EditorKit must be StyledEditorKit");
    }
    protected static final StyledDocument getStyledDocument(JEditorPane e) {
        Document d = e.getDocument();
        if (d instanceof StyledDocument) {
            return (StyledDocument) d;
        }
        throw new IllegalArgumentException("document must be StyledDocument");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();

        if(s.equals("藍色")){
            MutableAttributeSet blueAttr=new SimpleAttributeSet();
            StyleConstants.setForeground(blueAttr, Color.blue);
            setCharacterAttributes(textPane,blueAttr,false);


        }else if(s.equals("粉紅色")){
            MutableAttributeSet yellowAttr=new SimpleAttributeSet();
            StyleConstants.setForeground(yellowAttr,Color.pink);
            setCharacterAttributes(textPane,yellowAttr,false);

        }else if(s.equals("紅色")){
            MutableAttributeSet redAttr=new SimpleAttributeSet();
            StyleConstants.setForeground(redAttr,Color.red);
            setCharacterAttributes(textPane,redAttr,false);
        }else if(s.equals("標楷體")){
            MutableAttributeSet standardAttr = new SimpleAttributeSet();
            StyleConstants.setFontFamily(standardAttr,"標楷體");
            setCharacterAttributes(textPane,standardAttr,false);
        }else if(s.equals("微軟正黑體")){
            MutableAttributeSet microsoftBoldAttr =new SimpleAttributeSet();
            StyleConstants.setFontFamily(microsoftBoldAttr,"微軟正黑體");
            setCharacterAttributes(textPane,microsoftBoldAttr,false);
        }else if(s.equals("新細明體")){
            MutableAttributeSet newDetailAttr =new SimpleAttributeSet();
            StyleConstants.setFontFamily(newDetailAttr,"新細明體");
            setCharacterAttributes(textPane,newDetailAttr,false);
        }


    }
}
