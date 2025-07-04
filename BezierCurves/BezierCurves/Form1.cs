using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.Rebar;

namespace BezierCurves
{
    public partial class Form1 : Form
    {
        private DateTime startTime = DateTime.Now;
        private float animationDuration = 2f;
        Random rand = new Random();

        private Pen bluePen = new Pen(Color.Blue, 2);
        private Pen Pen = new Pen(Color.Red, 1);
        private float Progress = 0f;
        private bool construct = true;
        private bool ShowAnchors = true;
        List<Point> CurvePoints = new List<Point>();

        List<Point> Points = new List<Point>()
        {
            new Point(50, 200),
            new Point(150, 50),
            new Point(350, 50),
            new Point(450, 200)
        };

        private float GetProgress()
        {
            float elapsed = (float)(DateTime.Now - startTime).TotalSeconds;
            float cyclePosition = elapsed % (animationDuration * 2);
            float progress = 0f;

            if (cyclePosition < animationDuration)
            {
                progress = cyclePosition / animationDuration;
                construct = true;
            }
            else
            {
                progress = 2 - (cyclePosition / animationDuration);
                construct = false;
            }

            return progress;
        }

        public Form1()
        {
            InitializeComponent();
            this.Text = "Bezier Curve project";
            this.ClientSize = new Size(600, 400);
            this.Paint += new PaintEventHandler(CallDraw);
            this.DoubleBuffered = true;

            Timer animationTimer = new Timer();
            animationTimer.Interval = 1;
            animationTimer.Tick += (s, e) => this.Invalidate();
            animationTimer.Start();

            this.MouseDown += MMouseDown;
            this.MouseUp += MMouseUp;
            this.MouseMove += MMouseMove;
            this.MouseDoubleClick += MMouseDoubleClick;
        }

        private void CallDraw(object sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;
            g.Clear(Color.White);
            Progress = GetProgress();
            Draw(g, Points.ToArray(), 'A', Progress);

            foreach (Point point in CurvePoints)
                g.FillEllipse(Brushes.Blue, point.X, point.Y, 7, 7);
        }

        private void Draw(Graphics g, Point[] Points, char c, float t)
        {
            if (Points.Length < 1) return;
            Point[] nextPoints = new Point[Points.Length - 1];

            for (int i = 0; i < Points.Length; i++)
            {
                if (ShowAnchors)
                {
                    g.FillEllipse(Brushes.Red, Points[i].X - 5, Points[i].Y - 5, 10, 10);
                    g.DrawString($"{c}{i}", this.Font, Brushes.Black, Points[i].X - 10, Points[i].Y - 15);
                }

                if (i < Points.Length - 1)
                {
                    Color randomColor = Color.FromArgb(rand.Next(256), rand.Next(256), rand.Next(256));
                    Pen.Color = randomColor;
                    if (ShowAnchors) g.DrawLine(Pen, Points[i], Points[i + 1]);
                    Point p = LerpPoint(Points[i], Points[i + 1], t);
                    nextPoints[i] = p;
                }

                if (Points.Length == 1)
                {//Ponto da curva
                    if (construct)
                        CurvePoints.Add(Points[0]);
                    else if (CurvePoints.Count > 0)
                        CurvePoints.RemoveAt(CurvePoints.Count - 1);
                }
            }

            c++;
            Draw(g, nextPoints, c, t);
        }

        private int SelectedIndex = -1;

        private float Distance(Point a, Point b)
        {
            return (float)Math.Sqrt(Math.Pow(a.X - b.X, 2) + Math.Pow(a.Y - b.Y, 2));
        }
        private void MMouseUp(object sender, MouseEventArgs e)
        {
            SelectedIndex = -1;
            CurvePoints.Clear();
        }

        private void MMouseDown(object sender, MouseEventArgs e)
        {

            if (e.Button == MouseButtons.Left)
            {
                for (int i = 0; i < Points.Count; i++)
                {
                    if (Distance(e.Location, Points[i]) <= 10)
                    {
                        SelectedIndex = i;
                        break;
                    }
                }
            }
            else if (e.Button == MouseButtons.Right)
            {
                for (int i = 0; i < Points.Count; i++)
                {
                    if (Distance(e.Location, Points[i]) <= 10)
                    {
                        SelectedIndex = i;
                    }
                }
                if (SelectedIndex != -1)
                    Points.RemoveAt(SelectedIndex);
                else
                    Points.Add(e.Location);
            }
        }

        private void MMouseMove(object sender, MouseEventArgs e)
        {
            if (SelectedIndex != -1 && e.Button == MouseButtons.Left)
            {
                Points[SelectedIndex] = e.Location;
                this.Invalidate();
            }
        }

        private void MMouseDoubleClick(object sender, MouseEventArgs e) => ShowAnchors = !ShowAnchors;

        private Point LerpPoint (Point A, Point B, float t)
        {
            int x1 = A.X;
            int x2 = B.X;
            int y1 = A.Y;
            int y2 = B.Y;

            int newX = (int)(x1 + t * (x2 - x1));
            int newY = (int)(y1 + t * (y2 - y1));
            return new Point(newX, newY);
        }
    }
}