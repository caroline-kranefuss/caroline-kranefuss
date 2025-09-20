import math as math
import seaborn as sns
import matplotlib.pyplot as plt

class Ecdf():
    "Empirical cunulative distribution class"

    def __init__(self, x, chosen_quantile, outlier):
        self.x = x
        self.chosen_quantile = chosen_quantile
        self.outlier = outlier

    def __str__(self):
        return f"x = {self.x}" 

    def ecdf(self, x, Plot=True): 
        """ Creates an empirical cumulative distribution plot of the data """
        plot = sns.ecdfplot(x)
        if Plot:
            return plot 
        
    def quantile(self, chosen_quantile):
        """ Calculates a given quantile """
        x = sorted(self.x)
        quantile = x[math.floor((len(x)-1)*chosen_quantile)]
        return quantile

    def iqr(self):
        """ Calculates the inter-quartile range"""
        twenty_five = self.quantile(0.25)
        seventy_five = self.quantile(0.75)
        return seventy_five - twenty_five
    
    def whiskers(self):
        w1 = self.quantile(0.25) - 1.5 * self.iqr()
        w2 = self.quantile(0.75) + 1.5 * self.iqr()
        return w1, w2
    
    def outliers(self, outlier):
        """ Boolean that asks whether a value is an outlier """
        w1, w2 = self.whiskers()
        if outlier < w1:
            return True
        elif outlier > w2:
            return True 

    def summary(self, x, Plot=True):
        """ Computes a summary of the data, relying on past functions"""
        twenty_five, seventy_five = self.quantile(0.25), self.quantile(0.75)
        min, max, median = sorted(x)[0], sorted(x)[-1], self.quantile(0.5)
        if Plot:
            my_plot = plt.plot([twenty_five, seventy_five, min, max, median], np.ones(5), marker='o', linestyle='')
            return my_plot
   
obj = Ecdf(x, 0.2, 15)

print(Ecdf.ecdf(obj, x))

print(Ecdf.quantile(obj, 0.2))

print(Ecdf.iqr(obj))

print(Ecdf.outliers(obj, 15))

print(Ecdf.summary(obj, x))

