package nowCoder;

public class QuickPower {
	public double Power(double base, int exponent) {
		double result = 1;
		int n = 0;
		if (exponent < 0) {
			n = -exponent;
		} else {
			n = exponent;
		}
		while (n != 0) {
			if ((n & 1) == 1) {//取最后一位是否为1为1就与结果成低位掩码。
				result *= base;//分解成11 =2³×1 +2²×0 +2¹×1 +2º×1那么就是
			}
			base *= base;//每次是base^2(1),base^4(2),base^8(3)
			n = n >> 1;//右移去掉最后一位
		}
		if (exponent < 0) {
			return 1 / result;
		} else {
			return result;
		}

	}
}
