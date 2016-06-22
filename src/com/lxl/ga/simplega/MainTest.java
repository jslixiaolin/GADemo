package com.lxl.ga.simplega;

/**
 * 测试类
 *
 * @author lixiaolin
 * @createDate 2016-06-22 17:51
 */
public class MainTest {
    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
        // 期望的基因序列
        FitnessCalc.setSolution("1111000000000000000000000000000010001000001000000000000000001111");
        // 初始化一个种群
        Population myPop = new Population(50, true);

        // 不段迭代，进行进化操作。 直到找到期望的基因序列
        int generationCount = 0;
        System.out.println("初始种群适应度最佳为： " + myPop.getFittest().getFitness());
        while (myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()) {
            generationCount++;
            myPop = Algorithm.evolvePopulation(myPop);
            System.out.println("第" + generationCount + "次进化，种群最佳适应度为： " + myPop.getFittest().getFitness());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("进化结束!");
        System.out.println("总共进化" + generationCount + "次，用时 " + (endTime-currentTime) +"毫秒");

    }
}
