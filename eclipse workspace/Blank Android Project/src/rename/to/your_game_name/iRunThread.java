package rename.to.your_game_name;

public interface iRunThread extends Runnable
{
	public boolean isRunning();
	
	/**
	 * This method is depressing; it exists because Android doesn't implement a core Java Library method which Sun marked as "deprecated" about 10 years ago but never bothered to provide alternatives for - but Android doesn't throw an Error, it simply - SILENTLY - doesn't implement this core method; argh!
	 */
	public void waitUntilStoppedBecauseAndroidHasABrokenJVM();
	
	public void start();
}