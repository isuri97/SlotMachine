/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import model.Reel;
import model.Symbol;

/**
 *
 * @author isuri
 */
public class MainFrame extends JFrame {

    private JButton jBAddCoin;
    private JButton jBBetMax;
    private JButton jBBetOne;
    private JButton jBReset;
    private JButton jBSpin;
    private JButton jBStat;
    private JLabel jLBetA;
    private JLabel jLBetArea;
    private JLabel jLCreditA;
    private JLabel jLCreditArea;
    private JButton reel1;
    private JButton reel2;
    private JButton reel3;

    boolean toSpinReel, isNotSpin, is1stBetOne, is1stBetMax;
    int credit, bet, reel1Val, reel2Val, reel3Val;
    int wins, losses;

    public MainFrame() {
        createGUI();
        resetReels();
    }

    private void createGUI() {
        reel1 = new JButton();
        reel2 = new JButton();
        reel3 = new JButton();
        jBSpin = new JButton();
        jLCreditArea = new JLabel();
        jLBetArea = new JLabel();
        jBStat = new JButton();
        jBAddCoin = new JButton();
        jBBetOne = new JButton();
        jBBetMax = new JButton();
        jBReset = new JButton();
        jLCreditA = new JLabel();
        jLBetA = new JLabel();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(530, 430));
        setPreferredSize(new Dimension(530, 430));
        getContentPane().setLayout(null);
        setTitle("Slot Machine");
        reel1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reel1(e);
            }
        });
        getContentPane().add(reel1);
        reel1.setBounds(10, 38, 150, 150);

        reel2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reel2(e);
            }
        });
        getContentPane().add(reel2);
        reel2.setBounds(180, 40, 150, 150);

        reel3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reel3(e);
            }
        });
        getContentPane().add(reel3);
        reel3.setBounds(350, 40, 150, 150);

        jBSpin.setText("Spin");
        jBSpin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBSpin(e);
            }
        });
        getContentPane().add(jBSpin);
        jBSpin.setBounds(390, 230, 110, 30);

        jLCreditArea.setText("Credit Area :");
        getContentPane().add(jLCreditArea);
        jLCreditArea.setBounds(30, 230, 70, 20);

        jLBetArea.setText("Bet Area     :");
        getContentPane().add(jLBetArea);
        jLBetArea.setBounds(30, 250, 70, 20);

        jBStat.setText("Statictics");
        jBStat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBStat(e);
            }
        });
        getContentPane().add(jBStat);
        jBStat.setBounds(260, 310, 110, 30);

        jBAddCoin.setText("Add Coin");
        jBAddCoin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBAddCoin(e);
            }
        });
        getContentPane().add(jBAddCoin);
        jBAddCoin.setBounds(390, 270, 110, 30);

        jBBetOne.setText("Bet One");
        jBBetOne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBBetOne(e);
            }
        });
        getContentPane().add(jBBetOne);
        jBBetOne.setBounds(390, 310, 110, 30);

        jBBetMax.setText("Bet Max");
        jBBetMax.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBBetMax(e);
            }
        });
        getContentPane().add(jBBetMax);
        jBBetMax.setBounds(390, 350, 110, 30);

        jBReset.setText("Reset");
        jBReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBReset(e);
            }
        });
        getContentPane().add(jBReset);
        jBReset.setBounds(260, 350, 110, 30);
        getContentPane().add(jLCreditA);
        jLCreditA.setBounds(100, 230, 130, 20);
        getContentPane().add(jLBetA);
        jLBetA.setBounds(100, 250, 130, 20);
    }

    private void jBSpin(ActionEvent e) {
        if (bet == 0) {
            JOptionPane.showMessageDialog(this, "Add a bet 1st!");
        } else if (isNotSpin) {
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    Reel reel = new Reel();
                    ArrayList<Symbol> spin = reel.spin();
                    toSpinReel = true;
                    while (toSpinReel) {
                        for (Symbol symbol : spin) {
                            reel1Val = symbol.getValue();
                            reel1.setIcon(symbol.getImage());
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if (!toSpinReel) {
                                break;
                            }
                        }
                    }
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    Reel reel = new Reel();
                    ArrayList<Symbol> spin = reel.spin();
                    toSpinReel = true;
                    while (toSpinReel) {
                        for (Symbol symbol : spin) {
                            reel2Val = symbol.getValue();
                            reel2.setIcon(symbol.getImage());
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if (!toSpinReel) {
                                break;
                            }
                        }
                    }
                }
            });
            Thread thread3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    Reel reel = new Reel();
                    ArrayList<Symbol> spin = reel.spin();
                    toSpinReel = true;
                    while (toSpinReel) {
                        for (Symbol symbol : spin) {
                            reel3Val = symbol.getValue();
                            reel3.setIcon(symbol.getImage());
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if (!toSpinReel) {
                                break;
                            }
                        }
                    }
                }
            });
            thread1.start();
            thread2.start();
            thread3.start();
            isNotSpin = false;
        }
    }

    private void reel1(ActionEvent e) {
        stopSpin();
    }

    private void reel2(ActionEvent e) {
        stopSpin();
    }

    private void reel3(ActionEvent e) {
        stopSpin();
    }

    private void jBBetOne(ActionEvent e) {

        if (credit >= 1) {
            if (bet == 3) {
                credit += 2;
                jLCreditA.setText(credit + "");
            } else if (bet != 1) {
                credit -= 1;
                jLCreditA.setText(credit + "");
            }
            bet = 1;
            jLBetA.setText(1 + "");
        } else {
            JOptionPane.showMessageDialog(this, "Not enough credit");
        }
    }

    private void jBBetMax(ActionEvent e) {
        if (credit >= 3) {
            if (bet == 1) {
                credit -= 2;
                jLCreditA.setText(credit + "");
            } else if (bet != 3) {
                credit -= 3;
                jLCreditA.setText(credit + "");
            }
            bet = 3;
            jLBetA.setText(3 + "");
        } else {
            JOptionPane.showMessageDialog(this, "Not enough credit");
        }
    }

    private void jBAddCoin(ActionEvent e) {

        credit++;
        jLCreditA.setText(credit + "");
    }

    private void jBReset(ActionEvent e) {
        resetReels();
    }

    private void jBStat(ActionEvent e) {

        JOptionPane.showMessageDialog(this, "<html><table><tr><td>Wins</td><td>: " + wins + "</td></tr><tr><td>Losses</td><td>: " + losses + "</td></tr><tr><td>Avg. Credits</td><td>: " + credit + "</td></tr></table></html>");
        try {
            PrintWriter writer = new PrintWriter("Statictics.txt", "UTF-8");
            writer.println("Wins \t\t: " + wins);
            writer.println("Losses \t\t: " + losses);
            writer.println("Avg. Credits \t: " + credit);
            writer.close();
        } catch (IOException evt) {
        }
    }

    private void resetReels() {
        Reel reel = new Reel();
        ArrayList<Symbol> spin = reel.spin();
        reel1.setIcon(spin.get(0).getImage());
        reel2.setIcon(spin.get(0).getImage());
        reel3.setIcon(spin.get(0).getImage());

        toSpinReel = true;
        isNotSpin = true;
        is1stBetOne = true;
        is1stBetMax = true;
        credit = 10;
        bet = 0;
        wins = 0;
        losses = 0;
        jLCreditA.setText(credit + "");
        jLBetA.setText(bet + "");
        jLCreditA.setText(credit + "");
    }

    private void stopSpin() {
        if (!isNotSpin) {
            toSpinReel = false;
            isNotSpin = true;
            if (reel1Val != 0 && reel2Val != 0 && reel3Val != 0 && reel1Val == reel2Val && reel2Val == reel3Val && bet != 0) {
                credit += (reel1Val * bet);
                jLCreditA.setText(credit + "");
                JOptionPane.showMessageDialog(this, "You Won!");
                wins += 1;
            } else if (reel1Val != 0 && reel2Val != 0 && reel3Val != 0) {
                losses += 1;
            }
            bet = 0;
            jLBetA.setText(bet + "");
        }
    }

    public static void main(String args[]) {
        try {
            new MainFrame().setVisible(true);
        } catch (Exception e) {
        }
    }
}
