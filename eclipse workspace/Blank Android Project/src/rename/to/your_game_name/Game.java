package rename.this.to.your-game-name;

import java.util.*;

import org.tmachine.games.escapefromthepit.Components.Position;

import com.wikidot.entitysystems.rdbmsbeta.*;

import android.util.*;

public class Game
{
	protected EntityManager em;
	
	public Game( EntityManager initialEm )
	{
		em = initialEm;
	}
	
	protected void preSetupGame()
	{
	}
	
	protected void fixPositionsAfterPhoneRotated( int w, int h )
	{
		Log.i( getClass().getSimpleName(), "Fixing up positions after a screen-rotate; new width = " + w + ", new height = " + h );
		
		Set<UUID> allMovables = em.getAllEntitiesPossessingComponent( Position.class );
		
		/**
		 * 
		 */
		for( UUID entity : allMovables )
		{
			MetaEntity e = MetaEntity.loadFromEntityManager(entity);
			
			Position pos = e.get( Position.class );
			
			if( pos.x - pos.width / 2 < 0 )
				pos.x = pos.width / 2;
			if( pos.x + pos.width / 2 > w )
				pos.x = w - pos.width / 2;
			
			if( pos.y - pos.height / 2 < 0 )
				pos.y = pos.height / 2;
			if( pos.y + pos.height / 2 > h )
				pos.y = h - pos.height / 2;
		}
	}
}