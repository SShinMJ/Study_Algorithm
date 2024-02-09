using System;

namespace 백준
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string[] testCase = Console.ReadLine().Trim().Split(); 
            List<int> score = new List<int>();
            int sum = 0;
            int testNum = int.Parse(testCase[0]);
            int index = testNum;
            
            for(int j=1; j<=testNum; j++)
            {
                score.Add(int.Parse(testCase[j]));
                sum += score[score.Count-1];
            }
            score.Sort();
            
            for(int j=0; j<score.Count; j++)
            {
                if(score[j] > (double)sum/testNum) 
                {
                    index = j;
                    break;
                }
            }
            double aboveAvg = Math.Round((double)(testNum-index)/testNum*100, 3);
            Console.WriteLine("{0:#0.000}%", aboveAvg); 
        }
    }
}
