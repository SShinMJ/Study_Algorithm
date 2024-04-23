namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            StreamWriter writer = new StreamWriter(Console.OpenStandardOutput());
            StreamReader reader = new StreamReader(Console.OpenStandardInput());

            int N = int.Parse(reader.ReadLine());
            string[] input = reader.ReadLine().Split(' ');

            int[] waitTime = Array.ConvertAll(input, s => int.Parse(s));

            Array.Sort(waitTime);

            int answer = 0;
            int i = N;
            foreach(int time  in waitTime)
            {
                answer += time * N;
                N--;
            }

            writer.WriteLine(answer);

            writer.Close();
            reader.Close();
        }
    }
}