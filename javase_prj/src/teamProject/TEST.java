package teamProject;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class TEST extends JFrame {

    public TEST() {
        setTitle("range");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // JFrame의 레이아웃은 기본적으로 BorderLayout
        setLayout(new BorderLayout());

        // 1. NORTH 영역에 들어갈 JPanel 생성
        JPanel northPanel = new JPanel();
        
        // 2. JPanel의 레이아웃을 GridLayout(2, 2)로 설정
        northPanel.setLayout(new GridLayout(2, 2, 5, 5)); // 2행 2열, 간격 5px

        // 3. GridLayout에 컴포넌트 추가
        
        // 1행
        northPanel.add(new JLabel("                               range"));
        northPanel.add(new JLabel("")); // 2번째 셀은 비워둠

        // 2행 - 이 부분을 FlowLayout을 가진 JPanel로 한번 더 감싸서 해결
        JPanel secondRowPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        secondRowPanel1.add(new JLabel("시작"));
        secondRowPanel1.add(new JTextField(5));
        northPanel.add(secondRowPanel1);
        
        JPanel secondRowPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        secondRowPanel2.add(new JLabel("~ 끝"));
        secondRowPanel2.add(new JTextField(5));
        northPanel.add(secondRowPanel2);

        // 4. JPanel을 JFrame의 NORTH 영역에 추가
        add(northPanel, BorderLayout.NORTH);

        // CENTER 영역에는 JTextArea를 추가하여 채웁니다.
        JTextArea centerArea = new JTextArea("여기는 다른 내용이 들어갈 공간입니다.");
        add(centerArea, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TEST());
    }
}